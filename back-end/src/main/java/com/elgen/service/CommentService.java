package com.elgen.service;

import com.elgen.model.Comment;
import com.elgen.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            // Update the fields you want to update
            existingComment.setParentCommentId(comment.getParentCommentId());
            // Update other fields as needed
            return commentRepository.save(existingComment);
        }
        return null; // Handle not found scenario
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
