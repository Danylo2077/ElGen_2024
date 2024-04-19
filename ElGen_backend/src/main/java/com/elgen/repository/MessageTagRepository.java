package com.elgen.repository;

import com.elgen.model.MessageTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageTagRepository extends JpaRepository<MessageTag, Long> {

    Optional<MessageTag> findByMessageTagName(String name);
}
