package com.elgen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "attachment")
@Getter @Setter
public class Attachment {
    @Id
    @JsonProperty(value = "Attachment_id")
    @Column(name = "attachment_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attachment_id;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    @JsonProperty(value = "Attachment_name")
    @Column(name = "attachment_name")
    private String attachment_name;

    @Lob
    @Column(name = "icon")
    @Getter @Setter
    private Blob attachment_data;

}
