package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @JsonProperty(value = "Id")
    @Column(name = "user_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @JsonProperty(value = "Name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "Last_Name")
    @Column(name = "last_name")
    private String last_name;

    @JsonProperty(value = "Email")
    @Column(name = "email")
    private String email;

    @JsonProperty(value = "Password")
    @Column(name = "password")
    private String password;

    @JsonProperty(value = "Phone")
    @Column(name = "phone")
    private String phone;

    @JsonProperty(value = "Bio")
    @Column(name = "bio")
    private String bio;

    @JsonProperty(value = "User_Role")
    @Column(name = "user_role")
    private String user_role;

    @JsonProperty(value = "User_Account_Status_ID")
    @Column(name = "user_account_status_id")
    private String user_account_status_id;

    @JsonProperty(value = "Last_Login")
    @Column(name = "last_login")
    private Date last_login;

    @OneToMany(mappedBy = "user")
    private List<UserReaction> userReaction;

    @OneToMany(mappedBy = "user")
    private List<UserGroup> userGroup;

    @OneToOne(mappedBy = "user")
    private Follower follower;

    @OneToMany(mappedBy = "user")
    private List<UserChat> userChat;



    public User(Long user_id, String name, String last_name, String email, String password, String phone, String bio, String user_role, String user_account_status_id, Date last_login) {
        this.user_id = user_id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bio = bio;
        this.user_role = user_role;
        this.user_account_status_id = user_account_status_id;
        this.last_login = last_login;
    }

    public User(){}
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_account_status_id() {
        return user_account_status_id;
    }

    public void setUser_account_status_id(String user_account_status_id) {
        this.user_account_status_id = user_account_status_id;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

}