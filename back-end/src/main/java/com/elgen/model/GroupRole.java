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
@Getter @Setter
@Entity
@Table(name = "group_role")
public class GroupRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_role_id")
    private Long groupRoleId;

    @Column(name = "group_role_name")
    private String groupRoleName;

    // getters and setters
}