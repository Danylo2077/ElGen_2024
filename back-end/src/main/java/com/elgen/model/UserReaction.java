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
@Table(name = "user_reaction")
public class UserReaction {

    @Id
    @JsonProperty(value = "User_reaction_id")
    @Column(name = "user_reaction_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long user_reaction_id;

    @JsonProperty(value = "Reaction_id")
    @Column(name = "reaction_id")
    @Getter @Setter
    private Long reaction_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private User user;
}
