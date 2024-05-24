package com.elgen.controller;

import com.elgen.model.FileData;
import com.elgen.model.User;
import com.elgen.payload.response.MessageResponse;
import com.elgen.repository.FileDataRepository;
import com.elgen.service.FileDataService;
import com.elgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    PasswordEncoder encoder;

    private final FileDataService fileDataService;
    private final FileDataRepository fileDataRepository;
    private final UserService userService;

    @Value("${filePath}")
    private String filePath;


    public UserController(FileDataService fileDataService, FileDataRepository fileDataRepository, UserService userService) {
        this.fileDataService = fileDataService;
        this.fileDataRepository = fileDataRepository;
        this.userService = userService;
    }

    @PutMapping("/put/name/{username}")
    public ResponseEntity<?> updateUserName(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setName(updatedUser.getName());
            userService.updateUser(user);
        });
        return ResponseEntity.ok(new MessageResponse("User`s name changed successfully!"));
    }

    @PutMapping("/put/username/{username}")
    public ResponseEntity<?> updateUserUsername(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setUsername(updatedUser.getUsername());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s username changed successfully!"));
    }

    @PutMapping("/put/avatar/{username}")
    public ResponseEntity<?> uploadImageToFileDirectory(@PathVariable String username, @RequestParam("file") MultipartFile file) throws IOException {
        // Находим пользователя по имени пользователя
        Optional<User> optionalUser = userService.getUserByUsername(username);
        if (optionalUser.isEmpty()) {
            // Возвращаем ResponseEntity с ошибкой, если пользователь не найден
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // Получаем пользователя из Optional
        User user = optionalUser.get();

        // Проверяем, существует ли уже запись о файле для данного пользователя
        FileData existingFileData = fileDataRepository.findByUser(user);


        if(!("image/jpeg".equals(file.getContentType()) || "image/png".equals(file.getContentType()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPG, JPEG, PNG");
        }
        if (existingFileData != null) {
            String randomUUID = String.valueOf(UUID.randomUUID());
            fileDataService.uploadFileToFileDirectory(file,randomUUID);
            existingFileData.setName(randomUUID + "_"+ file.getOriginalFilename());
            existingFileData.setType(file.getContentType());
            existingFileData.setFilePath(filePath + File.separator + randomUUID + "_"+ file.getOriginalFilename());
            fileDataRepository.save(existingFileData);
            return ResponseEntity.status(HttpStatus.OK).body(existingFileData.getName());
        } else {
            String randomUUID = String.valueOf(UUID.randomUUID());
            fileDataService.uploadFileToFileDirectory(file, randomUUID);
            FileData fileData = new FileData();
            fileData.setName(UUID.randomUUID() + "_"+ file.getOriginalFilename());
            fileData.setType(file.getContentType());
            fileData.setFilePath(filePath + File.separator + randomUUID + "_"+ file.getOriginalFilename());
            fileData.setUser(user);
            fileDataRepository.save(fileData);
            return ResponseEntity.status(HttpStatus.OK).body(fileData.getName());
        }


    }


    @GetMapping("/avatar/{username}")
    public ResponseEntity<byte[]> downloadImageFromFileDirectory(@PathVariable String username){
        Optional<User> optionalUser = userService.getUserByUsername(username);

        User user = optionalUser.get();

        FileData file = fileDataRepository.findByUser(user);

        byte[] downloadFile = new byte[0];
        try {
            downloadFile = fileDataService.downloadFileFromFileDirectory(file.getName());
        } catch (IOException e) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPG, JPEG or PNG");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_PNG)
                .body(downloadFile);
    }

    @GetMapping("/get/name/{name}")
    public Optional<User> getUsersByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/get/username/{username}")
    public Optional<User> getUsersByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/put/lastlogin/{username}")
    public ResponseEntity<?> updateUserLastLogin(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setLastLogin(updatedUser.getLastLogin());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s lastLogin changed successfully!"));
    }

    @PutMapping("/put/bio/{username}")
    public ResponseEntity<?> updateUserBio(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setBio(updatedUser.getBio());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s bio changed successfully!"));
    }

    @PutMapping("/put/email/{username}")
    public ResponseEntity<?> updateUserEmail(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setEmail(updatedUser.getEmail());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s email changed successfully!"));
    }

    @PutMapping("/put/password/{username}")
    public ResponseEntity<?> updateUserPassword(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setPassword(encoder.encode(updatedUser.getPassword()));
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s password changed successfully!"));
    }
}
