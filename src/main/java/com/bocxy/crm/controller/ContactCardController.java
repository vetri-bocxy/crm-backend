package com.bocxy.crm.controller;

import com.bocxy.crm.apiService.ContactCardApiService;
import com.bocxy.crm.createDTO.ContactCardCreateDto;
import com.bocxy.crm.dto.ContactCardDto;
import com.bocxy.crm.dto.ResponseDto;
import com.bocxy.crm.updateDTO.ContactCardUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/contact-cards")
public class ContactCardController {
    @Autowired
    ContactCardApiService contactCardApiService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestBody ContactCardCreateDto createDto){
        try{
            ContactCardDto dto=contactCardApiService.create(createDto);
            return ResponseEntity.ok(new ResponseDto(200,"Created Successfully",dto));
        }catch (IllegalArgumentException e) {
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

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        try{
            List<ContactCardDto> dtoList=contactCardApiService.getAll();
            return ResponseEntity.ok(new ResponseDto(200,"Retrieved Successfully",dtoList));
        }catch (IllegalArgumentException e) {
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

    @PostMapping("/getById")
    public ResponseEntity<ResponseDto> getById(@RequestParam UUID id){
        try{
            ContactCardDto dto=contactCardApiService.getById(id);
            return ResponseEntity.ok(new ResponseDto(200,"Retrieved Successfully",dto));
        }catch (IllegalArgumentException e) {
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

    @PostMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestBody ContactCardUpdateDto dto){
        try{
            ContactCardDto data=contactCardApiService.update(dto);
            return ResponseEntity.ok(new ResponseDto(200,"Retrieved Successfully",data));
        }catch (IllegalArgumentException e) {
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

    @GetMapping("/getAllIdentityName")//List Brand name
    public ResponseEntity<ResponseDto> getAllIdentityName() {
        try {
            List<String> data = contactCardApiService.getAllIdentityName();
            return ResponseEntity.ok(new ResponseDto(200, "Retrieved Successfully", data));
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

    @GetMapping("/getContactCardCountLeadStatusWise")
    public ResponseEntity<ResponseDto> getContactCardCountLeadStatusWise() {
        try {
            Map<String, Integer> data = contactCardApiService.getContactCardCountLeadStatusWise();
            return ResponseEntity.ok(new ResponseDto(200, "Retrieved Successfully", data));
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
