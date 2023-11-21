package com.elgen.repository;

import com.elgen.model.UserReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReactionRepository extends JpaRepository<UserReaction, Long> {
}
