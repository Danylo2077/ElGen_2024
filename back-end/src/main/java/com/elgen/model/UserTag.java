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
@Getter @Setter
@Table(name = "user_tag")
public class UserTag {
    @Id
    @JsonProperty(value = "User_tag_id")
    @Column(name = "User_tag_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_tag_id;

    @JsonProperty(value = "User_tag_name")
    @Column(name = "User_tag_name")
    private String user_tag_name;
}
