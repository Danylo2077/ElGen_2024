package com.elgen.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import com.elgen.model.FileData;
import com.elgen.repository.FileDataRepository;
import com.elgen.service.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private FileDataRepository fileDataRepository;


    private final String FILE_PATH = "C:\\Users\\48574\\IdeaProjects\\ElGen_2024\\ElGen_backend\\uploads\\";
    @Override
    public String uploadFileToFileDirectory(MultipartFile file) throws IOException {
        String filePath = FILE_PATH+file.getOriginalFilename();//absolute path
        // TODO Auto-generated method stub
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        //copy your file into that particular path
        file.transferTo(new java.io.File(filePath));

        if(fileData!= null) {
            return "file uploaded successfully : "+file.getOriginalFilename()+ " and Files uploaded path is :"+filePath;
        }
        return null;
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