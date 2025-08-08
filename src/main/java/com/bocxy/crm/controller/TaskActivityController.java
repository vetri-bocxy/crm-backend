package com.bocxy.crm.controller;

import com.bocxy.crm.apiService.TaskActivityApiService;
import com.bocxy.crm.dto.ContactCardDto;
import com.bocxy.crm.dto.ResponseDto;
import com.bocxy.crm.dto.TaskActivityDto;
import com.bocxy.crm.entity.TaskActivity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task-activity")
public class TaskActivityController {
    @Autowired
    TaskActivityApiService taskActivityApiService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll(){
        try{
            List<TaskActivityDto> dtoList=taskActivityApiService.getAll();
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
}
