package com.example.jpa.springdatajpaspecifications.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Date createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }
}
