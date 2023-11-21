package com.elgen.repository;

import com.elgen.model.UserChat;
import com.elgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChatRepository extends JpaRepository<UserChat, String> {
    List<UserChat> findByUser(User user);
}
