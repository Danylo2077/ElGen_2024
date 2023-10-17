package com.elgen.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "reaction")
public class Reaction {
    @Id
    @JsonProperty(value = "Reaction_id")
    @Column(name = "reaction_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reaction_id;

    @JsonProperty(value = "Reaction_name")
    @Column(name = "reaction_name")
    private String reaction_name;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    public Reaction() {};

    public Reaction(Long reaction_id, String reaction_name, Long reation_type_id, Long message_id) {
        this.reaction_id = reaction_id;
        this.reaction_name = reaction_name;
        this.reation_type_id = reation_type_id;
        this.message = new Message();
        this.message.setMessage_id(message_id);
    }

    @JsonProperty(value = "Reaction_type_id")
    @Column(name = "reation_type_id")
    private Long reation_type_id;

    public Long getReaction_id() {
        return reaction_id;
    }

    public void setReaction_id(Long reaction_id) {
        this.reaction_id = reaction_id;
    }

    public String getReaction_name() {
        return reaction_name;
    }

    public void setReaction_name(String reaction_name) {
        this.reaction_name = reaction_name;
    }

    public Long getReation_type_id() {
        return reation_type_id;
    }

    public void setReation_type_id(Long reation_type_id) {
        this.reation_type_id = reation_type_id;
    }

    public Long getMessage_id() {
        return message.getMessage_id();
    }

    public void setMessage_id(Long message_id) {
        this.message.setMessage_id(message_id);
    }

}
