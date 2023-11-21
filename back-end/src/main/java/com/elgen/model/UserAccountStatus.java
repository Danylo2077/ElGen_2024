package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_account_status")
@Getter @Setter
public class UserAccountStatus {
    @Id
    @JsonProperty(value = "User_account_status_id")
    @Column(name = "user_account_status_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String user_account_status_id;

    @JsonProperty(value="User_account_status_name")
    @Column(name="user_account_status_name")
    private String user_account_status_name;

    @OneToMany(mappedBy = "userAccountStatus")
    private List<User> user;

}
