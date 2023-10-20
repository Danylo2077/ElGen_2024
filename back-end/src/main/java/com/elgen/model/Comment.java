package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name= "comment")
public class Comment {
    @Id
    @JsonProperty(value = "Comment_id")
    @Column(name = "comment_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    @JsonProperty(value = "Parrent_comment_id")
    @Column(name = "parent_comment_id")
    private Long parent_comment_id;

    public Comment(Long comment_id, Long parent_comment_id) {
        this.comment_id = comment_id;
        this.parent_comment_id = parent_comment_id;
    }

    public Comment() {

    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Long parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }
}
