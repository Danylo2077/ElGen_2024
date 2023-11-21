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
@Table(name = "user")
public class User implements Serializable {
    @Id
    @JsonProperty(value = "Id")
    @Column(name = "user_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long user_id;

    @JsonProperty(value = "Name")
    @Column(name = "name")
    @Getter @Setter
    private String name;

    @JsonProperty(value = "Last_Name")
    @Column(name = "last_name")
    @Getter @Setter
    private String last_name;

    @JsonProperty(value = "Email")
    @Column(name = "email")
    @Getter @Setter
    private String email;

    @JsonProperty(value = "Password")
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @JsonProperty(value = "Phone")
    @Column(name = "phone")
    @Getter @Setter
    private String phone;

    @JsonProperty(value = "Bio")
    @Column(name = "bio")
    @Getter @Setter
    private String bio;

//    @OneToOne
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JoinColumn(name = "User_account_status_id")
//    private UserAccountStatus userAccountStatus;

    @JsonProperty(value = "User_Role")
    @Column(name = "user_role")
    @Getter @Setter
    private String user_role;

    @JsonProperty(value = "Last_Login")
    @Column(name = "last_login")
    @Getter @Setter
    private Date last_login;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<UserReaction> userReaction;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<UserGroup> userGroup;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<Follower> follower;

//    @OneToOne(mappedBy = "user")
//    @Getter @Setter
//    private Follower follower;

    @OneToMany(mappedBy = "user")
    @Getter @Setter
    private List<UserChat> userChat;

    @ManyToOne
    @JoinColumn(name = "user_account_status_id")
    private UserAccountStatus userAccountStatus;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTag;

    private String full_name = name + " " + last_name;
}