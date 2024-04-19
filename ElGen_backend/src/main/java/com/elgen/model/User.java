package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@Entity
@JsonIgnoreProperties({"userAccountStatus", "role", "userTag"})
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", bio='" + bio + '\'' +
                ", roles=" + roles +
                ", lastLogin=" + lastLogin +
                ", userAccountStatusId=" + userAccountStatusId +
                ", userTagId=" + userTagId +
                ", username='" + username + '\'' +
                ", userAccountStatus=" + userAccountStatus +
                ", role=" + role +
                ", userTag=" + userTag +
                '}';
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bio")
    private String bio;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "user_account_status_id")
    private Long userAccountStatusId;

    @Column(name = "user_tag_id")
    private Long userTagId;

    @Column(name = "user_name")
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_account_status_id", referencedColumnName = "user_account_status_id", insertable = false, updatable = false)
    private UserAccountStatus userAccountStatus;

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id", insertable = false, updatable = false)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "user_tag_id", referencedColumnName = "user_tag_id", insertable = false, updatable = false)
    private UserTag userTag;

    public User(String username, String email, String encode) {
        this.username = username;
        this.email = email;
        this.password = encode;
    }

}