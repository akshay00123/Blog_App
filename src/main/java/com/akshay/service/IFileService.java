package com.akshay.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String uploadImage(String path, MultipartFile multipartFile) throws IOException;
}
