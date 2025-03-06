//package com.staging.staging_juwangi.controller;
//
//import java.io.IOException;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.*;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/api/uploadS3")
//@CrossOrigin(origins = "http://localhost:5173") // Sesuaikan dengan URL frontend jika perlu
//public class ImageUploadController {
//
//    @PostMapping("/upload-image")
//    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
//        try {
//            // Ganti URL berikut dengan endpoint API S3 yang disediakan
//            String s3ApiUrl = "https://example-s3-api.com/upload";
//
//            // Mempersiapkan header dan body untuk request multipart
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//            // Membungkus file dalam ByteArrayResource agar bisa dikirim sebagai multipart
//            ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
//                @Override
//                public String getFilename() {
//                    return file.getOriginalFilename();
//                }
//            };
//            body.add("file", resource);
//
//            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//            RestTemplate restTemplate = new RestTemplate();
//
//            // Mengirimkan file ke API S3
//            ResponseEntity<String> response = restTemplate.postForEntity(s3ApiUrl, requestEntity, String.class);
//
//            if(response.getStatusCode() == HttpStatus.OK) {
//                // Misal API S3 mengembalikan URL gambar yang telah diupload
//                return ResponseEntity.ok(response.getBody());
//            } else {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .body("Gagal mengupload gambar ke S3");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error: " + e.getMessage());
//        }
//    }
//}
