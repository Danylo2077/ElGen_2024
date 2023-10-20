package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="useraccountstatus")
public class UserAccountStatus {
    @Id
    @JsonProperty(value = "User_account_status_id")
    @Column(name = "user_account_status_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String user_account_status_id;
    @JsonProperty(value="User_account_status_name")
    @Column(name="user_account_status_name")
    private String user_account_status_name;

    public UserAccountStatus(String user_account_status_id, String user_account_status_name) {
        this.user_account_status_id = user_account_status_id;
        this.user_account_status_name = user_account_status_name;
    }

    public UserAccountStatus() {
    }

    public String getUser_account_status_id() {
        return user_account_status_id;
    }

    public void setUser_account_status_id(String user_account_status_id) {
        this.user_account_status_id = user_account_status_id;
    }

    public String getUser_account_status_name() {
        return user_account_status_name;
    }

    public void setUser_account_status_name(String user_account_status_name) {
        this.user_account_status_name = user_account_status_name;
    }
}
