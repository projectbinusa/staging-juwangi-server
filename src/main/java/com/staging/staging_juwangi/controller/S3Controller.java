package com.staging.staging_juwangi.controller;

import com.staging.staging_juwangi.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api/S3")
public class S3Controller {
    @Autowired
    private S3Service s3Service;

    private final String bucketName = "binus";

    @PostMapping("/upload")
    public ResponseEntity<?> uploadToS3(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File tidak boleh kosong");
        }

        try {
            String s3Response = s3Service.uploadFile(file);
            return ResponseEntity.ok(s3Response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gagal mengupload gambar ke S3");
        }
    }
}
//@Autowired
//    private AmazonS3 amazonS3;

//    @PostMapping("/upload")
//    public ResponseEntity<Map<String, Object>> uploadFile(@RequestPart("file") MultipartFile file) {
//        Map<String, Object> response = new HashMap<>();
//        try {
//            String fileName = file.getOriginalFilename();
//
//            PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(),null)
//                    .withCannedAcl(CannedAccessControlList.PublicRead);
//            amazonS3.putObject(request);
//
//            String imgageUrl = String.format("https://%s.is3.cloudhost.id/%s", bucketName ,fileName);
//
//            response.put("status", "200 OK");
//            response.put("code", 200);
//            Map<String, String> data = new HashMap<>();
//            data.put("filename", file.getOriginalFilename());
//            data.put("url", fileName);
//            response.put("data", data);
//            response.put("message", "Success");
//
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        } catch (IOException e) {
//            e.printStackTrace();
//            response.put("status", "500 Internal Server Error");
//            response.put("code", 500);
//            response.put("data", null);
//            response.put("message", "Failed to upload file: " + e.getMessage());
//
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//        }
//    }


