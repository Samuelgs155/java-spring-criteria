package com.example.jpa.springdatajpaspecifications.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class EstudianteDTO {
    private int id;

    private String name;

    private Date createdDate;
}
