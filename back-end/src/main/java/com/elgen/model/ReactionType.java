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
@Table(name = "reaction_type")
public class ReactionType {
    @Id
    @JsonProperty(value = "Reaction_type_id")
    @Column(name = "reaction_type_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long reaction_type_id;

    @JsonProperty(value = "Reaction_type_name")
    @Column(name = "reaction_type_name")
    @Getter @Setter
    private String reacrion_type_name;


    @JsonProperty(value = "Color")
    @Column(name = "color")
    @Getter @Setter
    private String color;

}
