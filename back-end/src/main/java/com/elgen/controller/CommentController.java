package com.elgen.controller;

import com.elgen.model.Comment;
import com.elgen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Api(description = "API for working with comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    @ApiOperation("Get all comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{commentId}")
    @ApiOperation("Get a specific comment by identifier")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    @ApiOperation("Create a new comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.ok(createdComment);
    }

    @PutMapping("/{commentId}")
    @ApiOperation("Update a comment by identifier")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment updatedCommentResult = commentService.updateComment(commentId, updatedComment);
        return ResponseEntity.ok(updatedCommentResult);
    }

    @DeleteMapping("/{commentId}")
    @ApiOperation("Delete a comment by identifier")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
