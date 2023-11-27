package com.elgen.service;

import com.elgen.model.Message;
import com.elgen.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(String messageId) {
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        return optionalMessage.orElse(null);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message updateMessage(String messageId, Message updatedMessage) {
        Optional<Message> optionalMessage = messageRepository.findById(messageId);
        if (optionalMessage.isPresent()) {
            Message existingMessage = optionalMessage.get();
            existingMessage.setMessage_text(updatedMessage.getMessage_text());
            existingMessage.setMessage_from(updatedMessage.getMessage_from());
            existingMessage.setMessage_date(updatedMessage.getMessage_date());
            existingMessage.setIs_pinned(updatedMessage.getIs_pinned());
            existingMessage.setReply_to(updatedMessage.getReply_to());
           // existingMessage.setComment_id(updatedMessage.getComment_id());
            existingMessage.setIs_post(updatedMessage.getIs_post());
            existingMessage.setChat_id(updatedMessage.getChat_id());
            // Оновіть інші поля, якщо потрібно
            return messageRepository.save(existingMessage);
        } else {
            // Обробка випадку, коли повідомлення не знайдене
            throw new RuntimeException("Повідомлення з id " + messageId + " не знайдено");
        }
    }

    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId.toString());
    }
}
