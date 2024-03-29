package com.elgen.service;

import com.elgen.model.User;
import com.elgen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User updatedUser) {
        Optional<User> existingUser = userRepository.findById(updatedUser.getUserId());

        existingUser.ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            userRepository.save(user);
        });
    }

    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteUserById(Long userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
