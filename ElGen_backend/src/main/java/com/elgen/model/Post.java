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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // Ссылка на пользователя, который создал этот пост

    @ManyToMany
    @JoinTable(
            name = "message_tag_mapping",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<MessageTag> tags;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<FileData> fileDataList;
}
