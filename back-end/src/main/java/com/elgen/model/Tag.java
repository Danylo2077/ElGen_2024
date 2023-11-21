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
@Table(name = "tag")
public class Tag {
    @Id
    @JsonProperty(value = "Tag_id")
    @Column(name = "tag_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tag_id;

    @JsonProperty(value = "Tag_name")
    @Column(name = "tag_name")
    private String tag_name;
}
