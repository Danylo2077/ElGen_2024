package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @JsonProperty(value = "Chat_id")
    @Column(name = "chat_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chat_id;

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getChat_name() {
        return chat_name;
    }

    public Chat(){};
    public Chat(Long chat_id, String chat_name, String chat_description) {
        this.chat_id = chat_id;
        this.chat_name = chat_name;
        this.chat_description = chat_description;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_description() {
        return chat_description;
    }

    public void setChat_description(String chat_description) {
        this.chat_description = chat_description;
    }

    @JsonProperty(value = "Chat_name")
    @Column(name = "chat_name")
    private String chat_name;
    @JsonProperty(value = "Chat_description")
    @Column(name = "chat_description")
    private String chat_description;

//    private Blob chat_logo;

}
