package com.example.jpa.springdatajpaspecifications.converter;





import com.example.jpa.springdatajpaspecifications.dto.EstudianteDTO;
import com.example.jpa.springdatajpaspecifications.model.Estudiante;

import java.util.List;
import java.util.stream.Collectors;

public class StudentConverter {
    public static List<EstudianteDTO> convertToStudentDTO(List<Estudiante> students) {
        return students.stream().map(s ->
                EstudianteDTO.builder()
                        .id(s.getId())
                        .name(s.getName())
                        .createdDate(s.getCreatedDate())
                        .build()
        ).collect(Collectors.toList());
    }

    public static Estudiante convertToStudent(EstudianteDTO studentDTO) {
        Estudiante students = new Estudiante();
        students.setName(studentDTO.getName());
        students.setCreatedDate(studentDTO.getCreatedDate());
        return students;
    }
}
