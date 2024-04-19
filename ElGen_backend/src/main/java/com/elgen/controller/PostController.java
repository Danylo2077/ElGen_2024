package com.elgen.controller;

import com.elgen.model.MessageTag;
import com.elgen.model.Post;
import com.elgen.repository.PostRepository;
import com.elgen.repository.MessageTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;
    private final MessageTagRepository tagRepository;

    @Autowired
    public PostController(PostRepository postRepository, MessageTagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    // Гет запрос по айдишнику для показа содержимого поста
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Пост запрос на создание поста с хештегами
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        List<MessageTag> tags = post.getTags();

        for (MessageTag tag : tags) {
            Optional<MessageTag> existingTag = tagRepository.findByMessageTagName(tag.getMessageTagName());

            if (existingTag.isPresent()) {
                tag.setMessageTagId(existingTag.get().getMessageTagId());
            } else {
                tagRepository.save(tag);
            }
        }

        Post savedPost = postRepository.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }


    // Пут запрос на изменение поста
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Post post = postOptional.get();
        post.setText(updatedPost.getText());
        post.setImages(updatedPost.getImages());

        List<MessageTag> updatedTags = updatedPost.getTags();
        List<MessageTag> savedTags = new ArrayList<>();

        for (MessageTag tag : updatedTags) {
            // Проверяем, сохранен ли тег в базе данных
            if (tag.getMessageTagId() == null) {
                // Если тег еще не сохранен, сохраняем его
                savedTags.add(tagRepository.save(tag));
            } else {
                // Если тег уже сохранен, используем его существующий идентификатор
                savedTags.add(tag);
            }
        }

        post.setTags(savedTags);

        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
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
