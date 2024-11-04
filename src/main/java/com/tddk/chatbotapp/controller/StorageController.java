package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.service.impl.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @PostMapping("/files/upload")
    public ResponseEntity<ApiRes<String>> uploadFiles(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiRes.<String>builder()
                        .code(HttpStatus.CREATED.value())
                        .data(storageService.uploadFiles(file))
                        .build()
        );
    }
}
