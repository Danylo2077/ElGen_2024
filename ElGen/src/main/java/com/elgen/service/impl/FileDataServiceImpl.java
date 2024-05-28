package com.elgen.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import com.elgen.model.FileData;
import com.elgen.repository.FileDataRepository;
import com.elgen.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private FileDataRepository fileDataRepository;


    @Value("${filePath}")
    private String path;
    @Override
    public String uploadFileToFileDirectory(MultipartFile file, String randomUUID) throws IOException {
        String contentType = file.getContentType();
        // Проверяем допустимые типы файлов
        if (!("image/jpeg".equals(contentType) || "image/png".equals(contentType))) {
            throw new IOException("Only JPG, JPEG or PNG");
        }
        String filePath = path + File.separator + randomUUID + "_" + file.getOriginalFilename(); // Абсолютный путь
        // Создаем объект FileData, но не сохраняем его пока
        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .build();

        // Копируем файл на указанное место
        file.transferTo(new java.io.File(filePath));

        // Возвращаем только путь к файлу, без сохранения объекта FileData
        return filePath;
    }

    @Override
    public byte[] downloadFileFromFileDirectory(String fileName) throws IOException {
        // TODO Auto-generated method stub


        Optional<FileData> fileDataObj = fileDataRepository.findByName(fileName);

        //first need to get the file path
        String filePath = fileDataObj.get().getFilePath();

        //got the file, now decompress it.
        byte[] imageFile = Files.readAllBytes(new java.io.File(filePath).toPath());

        return imageFile;

    }

}