package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@IdClass(User.class)
@Table(name = "userchat")
public class UserChat {
    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "user_id")
    private User user;
    @JsonProperty(value = "Chat_id")
    @Column(name = "chat_id")
    private String chat_id;

    public UserChat() {
    }

    public UserChat(Long user_id, String chat_id) {
        this.user = new User();
        this.user.setUser_id(user_id);
        this.chat_id = chat_id;
    }

    public Long getUser_id() {
        return user.getUser_id();
    }

    public void setUser_id(Long user_id) {
        this.user.setUser_id(user_id);
    }
    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }
}
