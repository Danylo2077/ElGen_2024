package com.elgen.repository;

import com.elgen.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
//    List<Comment> findCommentByComment_id(Long comment_id);
    Comment save(Comment comment);
//    void deleteByComment_id (Long comment_id);
}
