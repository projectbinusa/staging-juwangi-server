package com.staging.staging_juwangi.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
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
    private AmazonS3 amazonS3;

    private final String bucketName = "binus";

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestPart("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        try {
            String fileName = file.getOriginalFilename();

            PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(),null)
                    .withCannedAcl(CannedAccessControlList.PublicRead);
            amazonS3.putObject(request);

            String imgageUrl = String.format("https://%s.is3.cloudhost.id/%s", bucketName ,fileName);

            response.put("status", "200 OK");
            response.put("code", 200);
            Map<String, String> data = new HashMap<>();
            data.put("filename", file.getOriginalFilename());
            data.put("url", fileName);
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
