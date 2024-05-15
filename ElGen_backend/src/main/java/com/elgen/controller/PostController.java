package com.elgen.controller;

import com.elgen.model.FileData;
import com.elgen.model.MessageTag;
import com.elgen.model.Post;
import com.elgen.repository.FileDataRepository;
import com.elgen.repository.PostRepository;
import com.elgen.repository.MessageTagRepository;
import com.elgen.service.FileDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;
    private final FileDataService fileDataService;
    private final FileDataRepository fileDataRepository;
    private final MessageTagRepository tagRepository;

    @Autowired
    public PostController(PostRepository postRepository, FileDataService fileDataService, FileDataRepository fileDataRepository, MessageTagRepository tagRepository) {
        this.postRepository = postRepository;
        this.fileDataService = fileDataService;
        this.fileDataRepository = fileDataRepository;
        this.tagRepository = tagRepository;
    }

    // Гет запрос по айдишнику для показа содержимого поста
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Пост запрос на создание поста с хештегами и несколькими файлами
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestParam("files") MultipartFile[] files,
                                           @RequestParam("post") String postJson) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Post post = objectMapper.readValue(postJson, Post.class);

            List<FileData> fileDataList = new ArrayList<>();

            for (MultipartFile file : files) {
                String filePath = fileDataService.uploadFileToFileDirectory(file);
                FileData fileData = FileData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath(filePath)
                        .build();

                fileData.setPost(post); // Устанавливаем связь с постом
                fileDataList.add(fileData);
            }

            post.setFileDataList(fileDataList);

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
    }













    // Пут запрос на изменение поста
//    @PutMapping("/{postId}")
//    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
//        Optional<Post> postOptional = postRepository.findById(postId);
//        if (postOptional.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        Post post = postOptional.get();
//        post.setText(updatedPost.getText());
//        post.setImages(updatedPost.getImages());
//
//        List<MessageTag> updatedTags = updatedPost.getTags();
//        List<MessageTag> savedTags = new ArrayList<>();
//
//        for (MessageTag tag : updatedTags) {
//            // Проверяем, сохранен ли тег в базе данных
//            if (tag.getMessageTagId() == null) {
//                // Если тег еще не сохранен, сохраняем его
//                savedTags.add(tagRepository.save(tag));
//            } else {
//                // Если тег уже сохранен, используем его существующий идентификатор
//                savedTags.add(tag);
//            }
//        }
//
//        post.setTags(savedTags);
//
//        Post savedPost = postRepository.save(post);
//        return ResponseEntity.ok(savedPost);
//    }


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
