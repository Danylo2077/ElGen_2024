package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_status")
public class UserAccountStatus {
    @Id
    @JsonProperty(value = "User_account_status_id")
    @Column(name = "user_account_status_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long user_account_status_id;
    @JsonProperty(value="User_account_status_name")
    @Column(name="user_account_status_name")
    @Getter @Setter
    private String user_account_status_name;

}
