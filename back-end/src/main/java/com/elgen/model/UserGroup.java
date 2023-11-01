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
@IdClass(User.class)
@Table(name = "user_group")
public class UserGroup {
    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private User user;


    @Id
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "group_id")
    @Getter @Setter
    private Group group;


}
