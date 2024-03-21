package com.elgen.repository;

import com.elgen.model.ChatRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoleRepository extends JpaRepository<ChatRole, Long> {
}
