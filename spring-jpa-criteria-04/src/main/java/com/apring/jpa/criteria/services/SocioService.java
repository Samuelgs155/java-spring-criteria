package com.apring.jpa.criteria.services;

import com.apring.jpa.criteria.model.Socio;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SocioService {

    List<Socio> findSocios();
}
