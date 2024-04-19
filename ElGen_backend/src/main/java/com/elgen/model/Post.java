package com.elgen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "images")
    private String images;

    @ManyToMany
    @JoinTable(
            name = "message_tag_mapping",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<MessageTag> tags;

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для тексту
    public String getText() {
        return text;
    }

    // Сеттер для тексту
    public void setText(String text) {
        this.text = text;
    }

    // Геттер для зображень
    public String getImages() {
        return images;
    }

    // Сеттер для зображень
    public void setImages(String images) {
        this.images = images;
    }
}
