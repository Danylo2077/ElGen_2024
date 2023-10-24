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
@Table(name= "comment")
public class Comment {
    @Id
    @JsonProperty(value = "Comment_id")
    @Column(name = "comment_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long comment_id;
    @JsonProperty(value = "Parrent_comment_id")
    @Column(name = "parent_comment_id")
    @Getter @Setter
    private Long parent_comment_id;


}