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
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "message_from")
    private String messageFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "message_date")
    private Date messageDate;

    @Column(name = "is_pinned")
    private Boolean isPinned;

    @Column(name = "reply_to")
    private Long replyTo;

    @Column(name = "is_post")
    private Boolean isPost;

    @Column(name = "chat_id")
    private String chatId;

    @Column(name = "message_tag_id")
    private Long messageTagId;

    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id", insertable = false, updatable = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "message_tag_id", referencedColumnName = "message_tag_id", insertable = false, updatable = false)
    private MessageTag messageTag;

    @ManyToOne
    @JoinColumn(name = "reply_to", referencedColumnName = "message_id", insertable = false, updatable = false)
    private Message repliedToMessage;

}