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
@Table(name = "user_chat")
public class UserChat {
    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private User user;
    @JsonProperty(value = "Chat_id")
    @Column(name = "chat_id")
    @Getter @Setter
    private String chat_id;

}
