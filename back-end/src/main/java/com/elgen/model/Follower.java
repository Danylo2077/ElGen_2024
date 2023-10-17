package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "follower")
public class Follower {
    @Id
    @OneToOne
    @MapsId
    @JsonProperty(value = "User_id")
    @PrimaryKeyJoinColumn(name = "user_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private User user;
    @JsonProperty(value = "Follower_user_id")
    @Column(name = "follower_user_id")
    private Long follower_user_id;
    @JsonProperty(value = "Follow_user_id")
    @Column(name = "follow_user_id")
    private Long follow_user_id;

    public Follower(Long user_id, Long follower_user_id, Long follow_user_id) {
        this.user = new User();
        this.user.setUser_id(user_id);
        this.follower_user_id = follower_user_id;
        this.follow_user_id = follow_user_id;
    }

    public Follower() {
    }

    public Long getUser_id() {
        return user.getUser_id();
    }

    public void setUser_id(Long user_id) {
        this.user.setUser_id(user_id);
    }

    public Long getFollower_user_id() {
        return follower_user_id;
    }

    public void setFollower_user_id(Long follower_user_id) {
        this.follower_user_id = follower_user_id;
    }

    public Long getFollow_user_id() {
        return follow_user_id;
    }

    public void setFollow_user_id(Long follow_user_id) {
        this.follow_user_id = follow_user_id;
    }
}

