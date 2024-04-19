package com.elgen.controller;

import com.elgen.model.User;
import com.elgen.payload.response.MessageResponse;
import com.elgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    PasswordEncoder encoder;

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

    @GetMapping("/get/username/{username}")
    public Optional<User> getUsersByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @PutMapping("/put/lastlogin/{username}")
    public ResponseEntity<?> updateUserLastLogin(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setLastLogin(updatedUser.getLastLogin());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s lastLogin changed successfully!"));
    }

    @PutMapping("/put/bio/{username}")
    public ResponseEntity<?> updateUserBio(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setBio(updatedUser.getBio());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s bio changed successfully!"));
    }

    @PutMapping("/put/email/{username}")
    public ResponseEntity<?> updateUserEmail(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setEmail(updatedUser.getEmail());
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s email changed successfully!"));
    }

    @PutMapping("/put/password/{username}")
    public ResponseEntity<?> updateUserPassword(@PathVariable String username, @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByUsername(username);

        existingUser.ifPresent(user -> {
            user.setPassword(encoder.encode(updatedUser.getPassword()));
            userService.updateUser(user);
        });

        return ResponseEntity.ok(new MessageResponse("User`s password changed successfully!"));
    }
}
