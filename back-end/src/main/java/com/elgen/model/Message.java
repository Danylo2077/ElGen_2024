//model содержит модели данных, такие как User и Message.
package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
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

    @JsonProperty(value = "Reply_to")
    @Column(name = "reply_to")
    private Integer reply_to;

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

    //constructor without arguments
    public Message() {
    }
    //constructor with arguments
    public Message(Long message_id, String message_text, String message_from, Date message_date, Boolean is_pinned, Integer reply_to, Integer comment_id, Boolean is_post, String chat_id) {
        this.message_id = message_id;
        this.message_text = message_text;
        this.message_from = message_from;
        this.message_date = message_date;
        this.is_pinned = is_pinned;
        this.reply_to = reply_to;
        this.comment_id = comment_id;
        this.is_post = is_post;
        this.chat_id = chat_id;
    }

    // getters
    public Long getMessage_id() {
        return message_id;
    }

    public String getMessage_text() {
        return message_text;
    }

    public String getMessage_from() {
        return message_from;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public Boolean getIs_pinned() {
        return is_pinned;
    }

    public Integer getReply_to() {
        return reply_to;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public Boolean getIs_post() {
        return is_post;
    }

    public String getChat_id() {
        return chat_id;
    }

    // setters
    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public void setMessage_from(String message_from) {
        this.message_from = message_from;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }

    public void setIs_pinned(Boolean is_pinned) {
        this.is_pinned = is_pinned;
    }

    public void setReply_to(Integer reply_to) {
        this.reply_to = reply_to;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public void setIs_post(Boolean is_post) {
        this.is_post = is_post;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

}

