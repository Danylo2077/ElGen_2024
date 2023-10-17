package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@IdClass(User.class)
@Table(name = "usergroup")
public class UserGroup {
    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "user_id")
    private User user;


    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "group_id")
    private Group group;

    public UserGroup() {
    }

    public Long getUser_id() {
        return user.getUser_id();
    }

    public void setUser_id(Long user_id) {
        this.user.setUser_id(user_id);
    }

    public UserGroup(Long user_id, String group_id) {
        this.user = new User();
        this.user.setUser_id(user_id);
        this.group = new Group();
        this.group.setGroup_id(group_id);
    }

    public String getGroup_id() {
        return group.getGroup_id();
    }

    public void setGroup_id(String group_id) {
        this.group.setGroup_id(group_id);
    }
}
