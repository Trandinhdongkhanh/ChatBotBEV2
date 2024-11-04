package com.tddk.chatbotapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    String uploadFiles(MultipartFile file);
}
