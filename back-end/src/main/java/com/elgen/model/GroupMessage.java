package com.elgen.model;

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
@Table(name = "group_message")
public class GroupMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "group_id")
    @ManyToOne
    @Getter @Setter
    private Group group;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "message_id")
    @ManyToOne
    @Getter @Setter
    private Message message;
}