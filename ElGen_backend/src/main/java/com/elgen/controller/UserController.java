package com.elgen.controller;

import com.elgen.model.User;
import com.elgen.payload.response.MessageResponse;
import com.elgen.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/put/name/{username}")
    public ResponseEntity<?> updateUserName(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setName(updatedUser.getName());
            userService.updateUser(user);
        });
        return ResponseEntity.ok(new MessageResponse("User`s name changed successfully!"));
    }

    @PutMapping("/put/username/{username}")
    public ResponseEntity<?> updateUserUsername(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setUsername(updatedUser.getUsername());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s username changed successfully!"));
    }

    @GetMapping("/get/name/{name}")
    public Optional<User> getUsersByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/get/username/{name}")
    public Optional<User> getUsersByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
