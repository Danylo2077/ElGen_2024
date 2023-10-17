package com.elgen.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "userReaction")
public class UserReaction {

    @Id
    @JsonProperty(value = "User_reaction_id")
    @Column(name = "user_reaction_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_reaction_id;

    @JsonProperty(value = "Reaction_id")
    @Column(name = "reaction_id")
    private Long reaction_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public UserReaction(){};
    public UserReaction(Long user_reaction_id, Long user_id, Long reaction_id) {
        this.user = new User();
        this.user.setUser_id(user_id);
        this.user_reaction_id = user_reaction_id;
        this.reaction_id = reaction_id;
    }

    public Long getUser_reaction_id() {
        return user_reaction_id;
    }

    public void setUser_reaction_id(Long user_reaction_id) {
        this.user_reaction_id = user_reaction_id;
    }

    public Long getUser_id() {
        return user.getUser_id();
    }

    public void setUser_id(Long user_id) {
        this.user.setUser_id(user_id);
    }

    public Long getReaction_id() {
        return reaction_id;
    }

    public void setReaction_id(Long reaction_id) {
        this.reaction_id = reaction_id;
    }
}
