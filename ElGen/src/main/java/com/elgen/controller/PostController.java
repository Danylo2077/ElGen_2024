package com.elgen.controller;

import com.elgen.model.FileData;
import com.elgen.model.MessageTag;
import com.elgen.model.Post;
import com.elgen.repository.FileDataRepository;
import com.elgen.repository.PostRepository;
import com.elgen.repository.MessageTagRepository;
import com.elgen.service.FileDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;
    private final FileDataService fileDataService;
    private final FileDataRepository fileDataRepository;
    private final MessageTagRepository tagRepository;

    @Value("${filePath}")
    private String filePath;

    @Autowired
    public PostController(PostRepository postRepository, FileDataService fileDataService, FileDataRepository fileDataRepository, MessageTagRepository tagRepository) {
        this.postRepository = postRepository;
        this.fileDataService = fileDataService;
        this.fileDataRepository = fileDataRepository;
        this.tagRepository = tagRepository;
    }

    // Пост запрос на создание поста с хештегами и несколькими файлами
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@Nullable @RequestParam("files") MultipartFile[] files,
                                        @RequestParam("post") String postJson) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Post post = objectMapper.readValue(postJson, Post.class);

            // Если есть файлы, обрабатываем их
            if (files != null && files.length > 0) {
                List<FileData> fileDataList = new ArrayList<>();
                for (MultipartFile file : files) {
                    if (!("image/jpeg".equals(file.getContentType()) || "image/png".equals(file.getContentType()))) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only JPG, JPEG, PNG");
                    }
                    String randomUUID = String.valueOf(UUID.randomUUID());
                    fileDataService.uploadFileToFileDirectory(file, randomUUID);
                    FileData fileData = FileData.builder()
                            .name(randomUUID + "_" + file.getOriginalFilename())
                            .type(file.getContentType())
                            .filePath(filePath + File.separator + randomUUID + "_" + file.getOriginalFilename())
                            .build();

                    fileData.setPost(post); // Устанавливаем связь с постом
                    fileDataList.add(fileData);
                }

                post.setFileDataList(fileDataList);
            }

            // Сохраняем теги сообщения
            List<MessageTag> tags = post.getTags();
            List<MessageTag> savedTags = new ArrayList<>();
            for (MessageTag tag : tags) {
                Optional<MessageTag> existingTag = tagRepository.findByMessageTagName(tag.getMessageTagName());
                if (existingTag.isPresent()) {
                    savedTags.add(existingTag.get());
                } else {
                    savedTags.add(tagRepository.save(tag));
                }
            }
            post.setTags(savedTags);

            // Сохраняем пост в базе данных
            Post savedPost = postRepository.save(post);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }//TODO змінити назву ендпоінтів



    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPostByPostId(@PathVariable Long postId) {
        // Попытка получить пост с указанным postId
        Optional<Post> post = postRepository.findById(postId);

        if (post != null) {
            // Если пост найден, вернуть его вместе с кодом 200 OK
            return ResponseEntity.ok(post);
        } else {
            // Если пост не найден, вернуть код 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getPostByUserId(@PathVariable Long userId) {
        List<Post> postList = postRepository.findByUserUserId(userId);
        List<Post> postList1 = new ArrayList<>();
        for(int i = postList.size()-2; i<postList.size(); i++)
        {
            postList1.add(postList.get(i));
        }

        return ResponseEntity.ok(postList1);
    }


    @GetMapping("/photo/{fileName}")
    public ResponseEntity<?> downloadImageFromFileDirectory(@PathVariable String fileName) throws IOException{
        byte[] downloadFile = fileDataService.downloadFileFromFileDirectory(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(downloadFile);
    }


    // Делит запрос на удаление поста
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        if (!postRepository.existsById(postId)) {
            return ResponseEntity.notFound().build();
        }
        postRepository.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}
