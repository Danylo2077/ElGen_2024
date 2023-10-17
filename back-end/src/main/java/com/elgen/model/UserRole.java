package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "userrole")
public class UserRole {
    @Id
    @JsonProperty(value = "User_role_id")
    @Column(name = "user_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_role_id;
    @JsonProperty(value = "User_role_name")
    @Column(name = "user_role_name")
    private String user_role_name;

    public UserRole(Long user_role_id, String user_role_name) {
        this.user_role_id = user_role_id;
        this.user_role_name = user_role_name;
    }

    public UserRole() {

    }

    public Long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_role_name() {
        return user_role_name;
    }

    public void setUser_role_name(String user_role_name) {
        this.user_role_name = user_role_name;
    }
}
