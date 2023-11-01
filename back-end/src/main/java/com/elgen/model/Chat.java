package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @JsonProperty(value = "Chat_id")
    @Column(name = "chat_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long chat_id;

    @Lob
    @Column(name = "icon")
    @Getter @Setter
    private Blob icon;


    @JsonProperty(value = "Chat_name")
    @Column(name = "chat_name")
    @Getter @Setter
    private String chat_name;
    @JsonProperty(value = "Chat_description")
    @Column(name = "chat_description")
    @Getter @Setter
    private String chat_description;


}
