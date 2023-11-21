package com.elgen.repository;

import com.elgen.model.User;
import com.elgen.model.UserReaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReactionRepository extends JpaRepository<UserReaction, Long> {
    List<UserReaction> findByUser(User user);
}
