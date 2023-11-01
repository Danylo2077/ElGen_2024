//model содержит модели данных, такие как User и Message.
package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @JsonProperty(value = "Message_id")
    @Column(name = "message_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long message_id;

    @JsonProperty(value = "Message_text")
    @Column(name = "message_text")
    @Getter @Setter
    private String message_text;

    @JsonProperty(value = "Message_from")
    @Column(name = "message_from")
    @Getter @Setter
    private String message_from;

    @JsonProperty(value = "Message_date")
    @Column(name = "message_date")
    @Getter @Setter
    private Date message_date;

    @JsonProperty(value = "Is_pinned")
    @Column(name = "is_pinned")
    @Getter @Setter
    private Boolean is_pinned;

    @JsonProperty(value = "Reply_to")
    @Column(name = "reply_to")
    @Getter @Setter
    private Integer reply_to;

    @JsonProperty(value = "Comment_id")
    @Column(name = "comment_id")
    @Getter @Setter
    private Integer comment_id;
    @JsonProperty(value = "Is_post")
    @Column(name = "is_post")
    @Getter @Setter
    private Boolean is_post;

    @JsonProperty(value = "Сhat_id")
    @Column(name = "chat_id")
    @Getter @Setter
    private String chat_id;

    @OneToMany(mappedBy = "message")
    @Getter @Setter
    private List<GroupMessage> groupMessage;

    @OneToMany(mappedBy = "message")
    @Getter @Setter
    private List<Reaction> reaction;

    @OneToMany(mappedBy = "message")
    @Getter @Setter
    private List<Attachment> attachment;
}