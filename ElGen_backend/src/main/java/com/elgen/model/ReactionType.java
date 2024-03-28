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
@Getter @Setter
@Entity
@Table(name = "reaction_type")
public class ReactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reaction_type_id")
    private Long reactionTypeId;

    @Column(name = "reaction_type_name")
    private String reactionTypeName;

    @Column(name = "color")
    private String color;

    // getters and setters
}
