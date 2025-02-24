package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    @Autowired
    private final S3Service s3Service;

    @Autowired
    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestPart("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        try {
            String fileUrl = s3Service.uploadFile(file);

            response.put("status", "200 OK");
            response.put("code", 200);
            Map<String, String> data = new HashMap<>();
            data.put("filename", file.getOriginalFilename());
            data.put("url", fileUrl);
            response.put("data", data);
            response.put("message", "Success");

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IOException e) {
            e.printStackTrace();
            response.put("status", "500 Internal Server Error");
            response.put("code", 500);
            response.put("data", null);
            response.put("message", "Failed to upload file: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
