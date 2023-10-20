package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@IdClass(Group.class)
@Table(name = "groupmessage")
public class GroupMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "group_id")
    @ManyToOne
    private Group group;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "message_id")
    @ManyToOne
    private Message message;
    public GroupMessage(String group_id, Long message_id) {
        this.group = new Group();
        this.group.setGroup_id(group_id);
        this.message = new Message();
        this.message.setMessage_id(message_id);
    }

    public GroupMessage() {

    }

    public String getGroup_id() {
        return group.getGroup_id();
    }

    public void setGroup_id(String group_id) {
        this.group.setGroup_id(group_id);
    }

    public Long getMessage_id() {
        return message.getMessage_id();
    }

    public void setMessage_id(Long message_id) {
        this.message.setMessage_id(message_id);
    }


}
