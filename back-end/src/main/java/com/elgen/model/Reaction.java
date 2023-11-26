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
@Table(name = "reaction")
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reaction_id")
    private Long reactionId;

    @Column(name = "reaction_name")
    private String reactionName;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "reaction_type_id")
    private Long reactionTypeId;

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id", insertable = false, updatable = false)
    private Message message;

    @ManyToOne
    @JoinColumn(name = "reaction_type_id", referencedColumnName = "reaction_type_id", insertable = false, updatable = false)
    private ReactionType reactionType;

    // getters and setters
}
