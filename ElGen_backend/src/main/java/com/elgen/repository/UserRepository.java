package com.elgen.repository;

import com.elgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    Optional<User> findById (Long user_id);
    User save(User user);
    void delete(User user);
    void deleteById(Long user_id);
}