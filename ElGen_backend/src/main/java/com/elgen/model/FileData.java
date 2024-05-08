package com.elgen.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file_data")
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String filePath;

    @ManyToOne
    private Post post;

}