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
@Getter @Setter
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @JsonProperty(value = "Message_id")
    @Column(name = "message_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long message_id;

    @JsonProperty(value = "Message_text")
    @Column(name = "message_text")
    private String message_text;

    @JsonProperty(value = "Message_from")
    @Column(name = "message_from")
    private String message_from;

    @JsonProperty(value = "Message_date")
    @Column(name = "message_date")
    private Date message_date;

    @JsonProperty(value = "Is_pinned")
    @Column(name = "is_pinned")
    private Boolean is_pinned;

    @ManyToOne
    @JoinColumn(name = "reply_to")
    private Message reply_to;

    @JsonProperty(value = "Comment_id")
    @Column(name = "comment_id")
    private Integer comment_id;

    @JsonProperty(value = "Is_post")
    @Column(name = "is_post")
    private Boolean is_post;

    @JsonProperty(value = "Сhat_id")
    @Column(name = "chat_id")
    private String chat_id;

    @OneToMany(mappedBy = "message")
    private List<GroupMessage> groupMessage;

    @OneToMany(mappedBy = "message")
    private List<Reaction> reaction;

    @OneToMany(mappedBy = "message")
    private List<Attachment> attachment;

    @ManyToOne
    @JoinColumn(name = "message_tag_id")
    private MessageTag messageTag;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}