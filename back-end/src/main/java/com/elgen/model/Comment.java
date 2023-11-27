package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@Entity
@Table(name= "comment")
public class Comment {
    @Id
    @JsonProperty(value = "comment_id")
    @Column(name = "comment_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parent_comment_id;

    @OneToMany(mappedBy = "comment")
    private List<Message> message;

}