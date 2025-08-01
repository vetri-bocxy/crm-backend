package com.bocxy.crm.controller;

import com.bocxy.crm.apiService.TaskApiService;
import com.bocxy.crm.createDTO.TaskCreateDTO;
import com.bocxy.crm.dto.ResponseDto;
import com.bocxy.crm.dto.TaskDTO;
import com.bocxy.crm.updateDTO.TaskUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskApiService taskApiService;



    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestBody TaskCreateDTO createDto){
        try{
            TaskDTO dto=taskApiService.create(createDto);
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
            List<TaskDTO> dtoList=taskApiService.getAll();
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
            TaskDTO dto=taskApiService.getById(id);
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
    public ResponseEntity<ResponseDto> update(@RequestBody TaskUpdateDTO dto){
        try{
            TaskDTO data=taskApiService.update(dto);
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
}

