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
@Getter @Setter
@Entity
@Table(name = "group_message")
public class GroupMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id", insertable = false, updatable = false)
    private Message message;

    // getters and setters
}