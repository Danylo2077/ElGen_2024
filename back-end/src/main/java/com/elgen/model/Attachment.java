package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "attachment")
public class Attachment {
    @Id
    @JsonProperty(value = "Attachment_id")
    @Column(name = "attachment_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachment_id;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    public Long getAttachment_id() {
        return attachment_id;
    }

    public Attachment() {};
    public Attachment(Long attachment_id, String attachment_name, Long message_id) {
        this.attachment_id = attachment_id;
        this.attachment_name = attachment_name;
        this.message = new Message();
        this.message.setMessage_id(message_id);
    }

    public void setAttachment_id(Long attachment_id) {
        this.attachment_id = attachment_id;
    }

    public String getAttachment_name() {
        return attachment_name;
    }

    public void setAttachment_name(String attachment_name) {
        this.attachment_name = attachment_name;
    }

    public Long getMessage_id() {
        return message.getMessage_id();
    }

    public void setMessage_id(Long message_id) {
        this.message.setMessage_id(message_id);
    }

    @JsonProperty(value = "Attachment_name")
    @Column(name = "attachment_name")
    private String attachment_name;

//    private Blob attachment_data;


}
