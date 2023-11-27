package com.elgen.model;

import com.elgen.repository.MessageTagRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter @Setter
@Table(name = "message_tag")
public class MessageTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_tag_id")
    private Long messageTagId;

    @Column(name = "message_tag_name")
    private String messageTagName;

    // getters and setters
}
