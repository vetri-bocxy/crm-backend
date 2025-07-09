package com.bocxy.crm.controller;

import com.bocxy.crm.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<ResponseDto> uploadFile(@RequestParam("file") MultipartFile file,
                                                  HttpServletRequest request) {
        try {
            // Save to project root directory: ./uploads/
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(filename);
            file.transferTo(filePath.toFile());

            // Construct full URL: http://host:port/uploads/filename
            String baseUrl = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort();
            String fileUrl = baseUrl + "/uploads/" + filename;

            return ResponseEntity.ok(new ResponseDto(200, "Success", fileUrl));

        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDto(400, "Upload Failed: " + e.getMessage(), null));
        }
    }
}
