package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "chat_role")
public class ChatRole {
    @Id
    @JsonProperty(value = "Chat_role_id")
    @Column(name = "chat_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long chat_role_id;
    @JsonProperty(value = "Chat_role_name")
    @Column(name = "chat_role_name")
    @Getter @Setter
    private String chat_role_name;

}