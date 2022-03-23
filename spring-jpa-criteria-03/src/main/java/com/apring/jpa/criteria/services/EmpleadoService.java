package com.apring.jpa.criteria.services;

import com.apring.jpa.criteria.model.Empleado;
import com.apring.jpa.criteria.model.EmpleadoPage;
import com.apring.jpa.criteria.model.EmpleadoSearchCriteria;
import com.apring.jpa.criteria.repository.EmpleadoCriteriaRepository;
import com.apring.jpa.criteria.repository.EmpleadoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoCriteriaRepository empleadoCriteriaRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository,
                           EmpleadoCriteriaRepository empleadoCriteriaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.empleadoCriteriaRepository = empleadoCriteriaRepository;
    }

    @Transactional(readOnly = true)
    public Page<Empleado> getEmpleados(EmpleadoPage empleadoPage,
                                       EmpleadoSearchCriteria empleadoSearchCriteria) {
        return empleadoCriteriaRepository.findAllWithFilters(empleadoPage, empleadoSearchCriteria);
    }

    @Transactional
    public Empleado addEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
