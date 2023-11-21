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
@Table(name = "user_group")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "group_id")
    private Group group;


}
