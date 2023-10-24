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
@Table(name = "follower")
public class Follower {
    @Id
    @OneToOne
    @MapsId
    @JsonProperty(value = "User_id")
    @PrimaryKeyJoinColumn(name = "user_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private User user;
    @JsonProperty(value = "Follower_user_id")
    @Column(name = "follower_user_id")
    @Getter @Setter
    private Long follower_user_id;
    @JsonProperty(value = "Follow_user_id")
    @Column(name = "follow_user_id")
    @Getter @Setter
    private Long follow_user_id;
}

