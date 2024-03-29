package com.elgen.controller;

import com.elgen.model.User;
import com.elgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/email/{email}")
    public List<User> getUsersByEmail(@PathVariable String email) {
        return userService.getUsersByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Received request to create user: " + user);
        User createdUser = userService.createUser(user);
        System.out.println("Created user: " + createdUser);
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserById(id);

        existingUser.ifPresent(user -> {
            user.setName(updatedUser.getName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            userService.updateUser(user);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
