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
@IdClass(FollowerId.class)
@Table(name = "follower")
public class Follower {
    @Id
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "follower_user_id")
    private User follower_user_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "follow_user_id")
    private User follow_user_id;
}

