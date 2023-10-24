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
@Table(name = "user_role")
public class UserRole {
    @Id
    @JsonProperty(value = "User_role_id")
    @Column(name = "user_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long user_role_id;
    @JsonProperty(value = "User_role_name")
    @Column(name = "user_role_name")
    @Getter @Setter
    private String user_role_name;
}
