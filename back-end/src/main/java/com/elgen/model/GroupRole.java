package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="grouprole")
public class GroupRole {
    @Id
    @JsonProperty(value = "Group_role_id")
    @Column(name = "group_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long group_role_id;
    @JsonProperty(value = "Group_role_name")
    @Column(name = "group_role_name")
    private String group_role_name;

    public GroupRole() {

    }
    public GroupRole(Long group_role_id, String group_role_name) {
        this.group_role_id = group_role_id;
        this.group_role_name = group_role_name;
    }
    public Long getGroup_role_id() {
        return group_role_id;
    }
    public void setGroup_role_id(Long group_role_id) {
        this.group_role_id = group_role_id;
    }
    public String getGroup_role_name() {
        return group_role_name;
    }
    public void setGroup_role_name(String group_role_name) {
        this.group_role_name = group_role_name;
    }
}
