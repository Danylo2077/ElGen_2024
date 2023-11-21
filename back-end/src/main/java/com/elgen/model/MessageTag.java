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
    @JsonProperty(value = "Message_tag_id")
    @Column(name = "Message_tag_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long message_tag_id;

    @JsonProperty(value = "Message_tag_name")
    @Column(name = "Message_tag_name")
    private String message_tag_name;

    @OneToMany(mappedBy = "messageTag")
    private List<Message> message;
}
