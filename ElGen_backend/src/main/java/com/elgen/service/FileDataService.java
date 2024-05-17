package com.elgen.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileDataService {

    String uploadFileToFileDirectory(MultipartFile file, String filepath) throws IOException;

    byte[] downloadFileFromFileDirectory(String fileName) throws IOException;

}