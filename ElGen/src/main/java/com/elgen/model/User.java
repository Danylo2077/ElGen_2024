package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
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

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bio")
    private String bio;

    @Column(name = "user_role")
    private String userRole;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "user_account_status_id")
    private Long userAccountStatusId;

    @Column(name = "user_role_id")
    private Long userRoleId;

    @Column(name = "user_tag_id")
    private Long userTagId;

    @Column(name = "user_name")
    private Long userName;

    @ManyToOne
    @JoinColumn(name = "user_account_status_id", referencedColumnName = "user_account_status_id", insertable = false, updatable = false)
    private UserAccountStatus userAccountStatus;

    @ManyToOne
    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id", insertable = false, updatable = false)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "user_tag_id", referencedColumnName = "user_tag_id", insertable = false, updatable = false)
    private UserTag userTag;

}
