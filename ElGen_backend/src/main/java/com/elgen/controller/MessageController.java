package com.elgen.controller;

import com.elgen.model.Message;
import com.elgen.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@Api(description = "API for working with messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    @ApiOperation("Get all messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{messageId}")
    @ApiOperation("Get a specific message by identifier")
    public ResponseEntity<Message> getMessageById(@PathVariable Long messageId) {
        Message message = messageService.getMessageById(messageId);
        return ResponseEntity.ok(message);
    }

    @PostMapping
    @ApiOperation("Create a new message")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

//    @PutMapping("/{messageId}")
//    @ApiOperation("Update a message by identifier")
//    public ResponseEntity<Message> updateMessage(@PathVariable String messageId, @RequestBody Message updatedMessage) {
//        Message updatedMessageResult = messageService.updateMessage(messageId, updatedMessage);
//        return ResponseEntity.ok(updatedMessageResult);
//    }

    @DeleteMapping("/{messageId}")
    @ApiOperation("Delete a message by identifier")
    public ResponseEntity<Void> deleteMessage(@PathVariable Message message) {
        messageService.deleteMessage(message);
        return ResponseEntity.noContent().build();
    }
}
