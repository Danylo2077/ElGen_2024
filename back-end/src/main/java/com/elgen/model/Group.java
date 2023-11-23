package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter @Setter
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

    @Lob
    @Column(name = "icon")
    private Blob group_logo;

    @OneToMany(mappedBy = "group")
    private List<UserGroup> userGroup;

    @OneToMany(mappedBy = "group")
    private List<GroupMessage> groupMessage;
}