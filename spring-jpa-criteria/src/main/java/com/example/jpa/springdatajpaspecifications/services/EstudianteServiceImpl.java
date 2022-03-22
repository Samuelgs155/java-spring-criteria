package com.example.jpa.springdatajpaspecifications.services;

import com.example.jpa.springdatajpaspecifications.converter.StudentConverter;
import com.example.jpa.springdatajpaspecifications.dto.EstudianteDTO;
import com.example.jpa.springdatajpaspecifications.model.Estudiante;
import com.example.jpa.springdatajpaspecifications.repository.EstudianteRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository studentRepository;

    public EstudianteServiceImpl(EstudianteRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(EstudianteDTO student) {
        studentRepository.save(StudentConverter.convertToStudent(student));
    }

    @Override
    public List<EstudianteDTO> getStudents(Date fromDate, Date toDate, String name, Pageable pageable) {
        List<Estudiante> students = studentRepository.findAll((Specification<Estudiante>) (root, cq, cb) -> {
            Predicate p = cb.conjunction();
            if (Objects.nonNull(fromDate) && Objects.nonNull(toDate) && fromDate.before(toDate)) {
                p = cb.and(p, cb.between(root.get("createdDate"), fromDate, toDate));
            }
            if (!StringUtils.isEmpty(name)) {
                p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
            }
            cq.orderBy(cb.desc(root.get("name")), cb.asc(root.get("id")));
            return p;
        }, pageable).getContent();
        return StudentConverter.convertToStudentDTO(students);
    }
}
