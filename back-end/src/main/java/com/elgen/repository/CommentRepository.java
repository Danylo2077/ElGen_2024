package com.elgen.repository;

import com.elgen.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByCommentId(Long commentId);
    void deleteByCommentId(Long commentId);
    boolean existsByCommentId(Long commentId);

    List<Comment> findAll();
    long count();
    void delete(Comment comment);
    void deleteAll();

}
