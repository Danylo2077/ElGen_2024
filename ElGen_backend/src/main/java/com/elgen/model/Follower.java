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
@Entity
@Getter @Setter
@Table(name = "follower")
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "follower_user_id")
    private Long followerUserId;

    @Column(name = "follow_user_id")
    private Long followUserId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User followerUser;

    @ManyToOne
    @JoinColumn(name = "follow_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User followUser;

    // getters and setters
}

