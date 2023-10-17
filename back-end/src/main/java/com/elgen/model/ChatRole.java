package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "chatrole")
public class ChatRole {
    @Id
    @JsonProperty(value = "Chat_role_id")
    @Column(name = "chat_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chat_role_id;
    @JsonProperty(value = "Chat_role_name")
    @Column(name = "chat_role_name")
    private String chat_role_name;

    public ChatRole() {
    }

    public ChatRole(Long chat_role_id, String chat_role_name) {
        this.chat_role_id = chat_role_id;
        this.chat_role_name = chat_role_name;
    }

    public Long getChat_role_id() {
        return chat_role_id;
    }

    public void setChat_role_id(Long chat_role_id) {
        this.chat_role_id = chat_role_id;
    }

    public String getChat_role_name() {
        return chat_role_name;
    }

    public void setChat_role_name(String chat_role_name) {
        this.chat_role_name = chat_role_name;
    }
}
