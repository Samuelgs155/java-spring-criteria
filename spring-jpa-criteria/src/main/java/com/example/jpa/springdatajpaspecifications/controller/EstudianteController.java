package com.example.jpa.springdatajpaspecifications.controller;


import com.example.jpa.springdatajpaspecifications.dto.EstudianteDTO;
import com.example.jpa.springdatajpaspecifications.services.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EstudianteController {

    private static final String DATE_PATTERN = "yyyy/MM/dd";
    private final EstudianteService studentService;

    public EstudianteController(EstudianteService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<EstudianteDTO> getStudents(@RequestParam(required = false)
                                        @DateTimeFormat(pattern = DATE_PATTERN) Date fromDate,
                                           @RequestParam(required = false)
                                        @DateTimeFormat(pattern = DATE_PATTERN) Date toDate,
                                           @RequestParam(required = false) String name,
                                           Pageable pageable){
        return studentService.getStudents(fromDate, toDate, name, pageable);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody EstudianteDTO student) {
        studentService.addStudent(student);
    }
}
