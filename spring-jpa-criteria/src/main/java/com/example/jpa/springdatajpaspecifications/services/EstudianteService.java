package com.example.jpa.springdatajpaspecifications.services;

import java.util.Date;
import java.util.List;

import com.example.jpa.springdatajpaspecifications.dto.EstudianteDTO;
import org.springframework.data.domain.Pageable;

public interface EstudianteService {
    void addStudent(EstudianteDTO student);

    List<EstudianteDTO> getStudents(Date fromDate, Date toDate, String name, Pageable pageable);
}
