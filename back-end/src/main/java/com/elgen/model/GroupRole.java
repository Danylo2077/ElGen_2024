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
@Table(name="group_role")
public class GroupRole {
    @Id
    @JsonProperty(value = "Group_role_id")
    @Column(name = "group_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long group_role_id;
    @JsonProperty(value = "Group_role_name")
    @Column(name = "group_role_name")
    @Getter @Setter
    private String group_role_name;

}