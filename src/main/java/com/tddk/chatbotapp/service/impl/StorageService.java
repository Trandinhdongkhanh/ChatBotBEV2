package com.tddk.chatbotapp.service.impl;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.tddk.chatbotapp.service.IStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class StorageService implements IStorageService {
    @Value("${fb.key}")
    private String key;
    @Value("${fb.bucket}")
    private String bucket;
    private static final String BASE_URL = "https://firebasestorage.googleapis.com/v0/b/";

    @Override
    public String uploadFiles(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();                        // to get original file name
            fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName));  // to generated random string values for file name.

            return this.uploadFile(file, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return "Image couldn't upload, Something went wrong";
        }
    }

    private String uploadFile(MultipartFile file, String fileName) throws IOException {
        BlobId blobId = BlobId.of(bucket, fileName); // Replace with your bucker name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        InputStream inputStream = StorageService.class.getClassLoader().getResourceAsStream(key); // change the file name with your one
        Credentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, file.getBytes());

//        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/<bucket-name>/o/%s?alt=media";
        return BASE_URL + bucket + "/o/" + URLEncoder.encode(fileName, StandardCharsets.UTF_8) + "?alt=media";
    }


    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
