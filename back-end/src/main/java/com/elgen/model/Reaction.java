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
@Table(name = "reaction")
public class Reaction {
    @Id
    @JsonProperty(value = "Reaction_id")
    @Column(name = "reaction_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long reaction_id;

    @JsonProperty(value = "Reaction_name")
    @Column(name = "reaction_name")
    @Getter @Setter
    private String reaction_name;

    @ManyToOne
    @JoinColumn(name = "message_id")
    @Getter @Setter
    private Message message;



    @JsonProperty(value = "Reaction_type_id")
    @Column(name = "reaction_type_id")
    @Getter @Setter
    private Long reaction_type_id;

}
