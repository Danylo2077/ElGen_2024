package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "group")
public class Group implements Serializable {
    @Id
    @JsonProperty(value = "Group_id")
    @Column(name = "group_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String group_id;

    @JsonProperty(value = "Group_name")
    @Column(name = "group_name")
    private String group_name;

    @JsonProperty(value = "Group_description")
    @Column(name = "group_description")
    private String group_description;
//    private Blob group_logo;

    @OneToMany(mappedBy = "group")
    private List<UserGroup> userGroup;

    @OneToMany(mappedBy = "group")
    private List<GroupMessage> groupMessage;

    //constructor without arguments
    public Group() {
    }
    //constructor with arguments
    public Group(String group_name, String group_id, String group_description, Blob group_logo) {
        this.group_name = group_name;
        this.group_id = group_id;
        this.group_description = group_description;
//        this.group_logo = group_logo;
    }

    // getters
    public String getGroup_name() {
        return group_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public String getGroup_description() {
        return group_description;
    }

//    public Blob getGroup_logo() {
//        return group_logo;
//    }

    // Setters
    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public void setGroup_description(String group_description) {
        this.group_description = group_description;
    }

//    public void setGroup_logo(Blob group_logo) {
//        this.group_logo = group_logo;
//    }
}
