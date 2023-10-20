package com.elgen.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "reactionType")
public class ReactionType {
    @Id
    @JsonProperty(value = "Reaction_type_id")
    @Column(name = "reaction_type_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reaction_type_id;


    public ReactionType(){};
    public ReactionType(Long reaction_type_id, String reacrion_type_name, String color) {
        this.reaction_type_id = reaction_type_id;
        this.reacrion_type_name = reacrion_type_name;
        this.color = color;
    }

    @JsonProperty(value = "Reaction_type_name")
    @Column(name = "reaction_type_name")
    private String reacrion_type_name;

    public Long getReaction_type_id() {
        return reaction_type_id;
    }

    public void setReaction_type_id(Long reaction_type_id) {
        this.reaction_type_id = reaction_type_id;
    }

    public String getReacrion_type_name() {
        return reacrion_type_name;
    }

    public void setReacrion_type_name(String reacrion_type_name) {
        this.reacrion_type_name = reacrion_type_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty(value = "Color")
    @Column(name = "color")
    private String color;

}
