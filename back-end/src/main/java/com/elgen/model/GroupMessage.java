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
    @ManyToOne
    @JoinColumn(name = "group_id")
    @Getter @Setter
    private Group group;

    @Id
    @ManyToOne
    @JoinColumn(name = "message_id")
    @Getter @Setter
    private Message message;
}