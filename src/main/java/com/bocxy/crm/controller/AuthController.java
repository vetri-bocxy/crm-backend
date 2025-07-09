package com.bocxy.crm.controller;

import com.bocxy.crm.dto.AuthRequest;
import com.bocxy.crm.dto.AuthResponse;
import com.bocxy.crm.createDTO.UserCreateDto;
import com.bocxy.crm.dto.ResponseDto;
import com.bocxy.crm.entity.User;
import com.bocxy.crm.repository.UserRepository;
import com.bocxy.crm.security.JwtUtils;
import com.bocxy.crm.security.SecurityConfig;
import com.bocxy.crm.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private UserService userService;
    @Autowired private JwtUtils jwtUtils;
    @Autowired private SecurityConfig.UserDetailsServiceImpl userDetailsService;
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            Optional<User> userOpt = userRepository.findByUsername(authRequest.getUsername());
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                if (passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
                    String token = jwtUtils.generateToken(user);
                    return ResponseEntity.ok(new AuthResponse(token, user.getRole().name(),user));
                } else {
                    return ResponseEntity.status(401).body(new AuthResponse("Invalid password", null,user));
                }
            } else {
                throw new EntityNotFoundException("User not found with username: " + authRequest.getUsername());
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(new AuthResponse(e.getMessage(), null,null));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new AuthResponse("Bad request: " + e.getMessage(), null,null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body(new AuthResponse("Runtime error: " + e.getMessage(), null,null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AuthResponse("Unexpected error: " + e.getMessage(), null,null));
        }
    }

    @GetMapping("/getUsername")
    public ResponseEntity<ResponseDto> getUsername(@RequestParam String phoneNumber) {
        try {
            String username = userService.getUsername(phoneNumber);
            return ResponseEntity.ok(new ResponseDto(200,"Username Retrieved Successfully",username));
        } catch (IllegalArgumentException e) {
            // Return 400 for bad request errors like invalid input
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(400, e.getMessage(), null));
        } catch (EntityNotFoundException e) {
            // Return 404 for not found errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(404, e.getMessage(), null));
        } catch (Exception e) {
            // Return 500 for generic internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(500, "Internal Server Error: " + e.getMessage(), null));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserCreateDto dto) {
        try {
            User savedUser = userService.registerUser(dto);

            return ResponseEntity.ok(new ResponseDto(200,"User Registered Successfully",savedUser));
        } catch (IllegalArgumentException e) {
            // Return 400 for bad request errors like invalid input
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(400, e.getMessage(), null));
        } catch (EntityNotFoundException e) {
            // Return 404 for not found errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto(404, e.getMessage(), null));
        } catch (Exception e) {
            // Return 500 for generic internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(500, "Internal Server Error: " + e.getMessage(), null));
        }
    }
}
