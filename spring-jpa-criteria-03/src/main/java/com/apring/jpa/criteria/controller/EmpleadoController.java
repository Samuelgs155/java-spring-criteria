package com.apring.jpa.criteria.controller;


import com.apring.jpa.criteria.model.Empleado;
import com.apring.jpa.criteria.model.EmpleadoPage;
import com.apring.jpa.criteria.model.EmpleadoSearchCriteria;
import com.apring.jpa.criteria.services.EmpleadoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<Page<Empleado>> getEmpleados(EmpleadoPage empleadoPage,
                                                       EmpleadoSearchCriteria empleadoSearchCriteria) {
        return new ResponseEntity<>(empleadoService.getEmpleados(empleadoPage, empleadoSearchCriteria),
                HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.addEmpleado(empleado), HttpStatus.CREATED);
    }
}
