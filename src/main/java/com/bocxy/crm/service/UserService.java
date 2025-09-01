package com.bocxy.crm.service;

import com.bocxy.crm.createDTO.UserCreateDto;
import com.bocxy.crm.entity.User;
import com.bocxy.crm.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User registerUser(UserCreateDto dto) {
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setDesignation(dto.getDesignation());
        user.setProfilePicPath(dto.getProfilePicPath());
        user.setRole(dto.getRole());

        return userRepository.save(user);
    }

    public String getUsername(String phoneNumber) {
        User user=userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(()-> new EntityNotFoundException("User not matched with the number "+phoneNumber));
        return user.getUsername();
    }

    public List<String> getUsernames() {
        return userRepository.findUsernames();
    }
}
