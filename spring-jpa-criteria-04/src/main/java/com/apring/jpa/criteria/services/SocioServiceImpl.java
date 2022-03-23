package com.apring.jpa.criteria.services;

import com.apring.jpa.criteria.model.Socio;
import com.apring.jpa.criteria.repository.SocioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SocioServiceImpl implements SocioService{

    private final SocioRepository socioRepository;

    public SocioServiceImpl(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Socio> findSocios() {
        return socioRepository.findAll();
    }
}
