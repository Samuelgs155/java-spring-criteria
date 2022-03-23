package com.apring.jpa.criteria.controller;

import com.apring.jpa.criteria.model.Socio;
import com.apring.jpa.criteria.services.SocioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocioController {

    private final SocioServiceImpl socioService;

    public SocioController(SocioServiceImpl socioService) {
        this.socioService = socioService;
    }


    @GetMapping("/socios")
    public ResponseEntity<?> getAllSocios() {
        return new ResponseEntity<>(socioService.findSocios(), HttpStatus.OK);
    }
}
