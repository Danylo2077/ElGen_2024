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
    List<User> findByUserRole(String user_role);
    User save(User user);
    void delete(User user);
    void deleteByUser_id(Long user_id);
}
