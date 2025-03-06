package com.staging.staging_juwangi.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3Service {
    private static final Logger logger = LoggerFactory.getLogger(S3Service.class);
    private final AmazonS3 amazonS3;

    @Value("${s3.bucketName}")
    private String bucketName;

    @Value("${s3.endpoint}")
    private String s3Endpoint;

    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        logger.info("Uploading file: {}", fileName);
        logger.info("Bucket Name: {}", bucketName);
        logger.info("S3 Endpoint: {}", s3Endpoint);

        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            PutObjectRequest request = new PutObjectRequest(bucketName, fileName, file.getInputStream(), metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead);

            amazonS3.putObject(request);
            String fileUrl = amazonS3.getUrl(bucketName, fileName).toString();
            logger.info("File uploaded successfully: {}", fileUrl);
            return fileUrl;

        } catch (Exception e) {
            logger.error("Error uploading file to S3: {}",fileName, e.getMessage(), e);
            throw new RuntimeException("Upload gagal: " + e.getMessage());
        }
    }

    public boolean deleteFile(String fileName) {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
