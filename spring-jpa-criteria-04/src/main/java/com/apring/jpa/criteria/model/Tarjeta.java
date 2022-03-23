package com.apring.jpa.criteria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tarjetas")
public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private Date caducidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="socios_dni")
    @JsonIgnoreProperties("tarjeta")
    private Socio socio;

    public Tarjeta() {
    }

    public Tarjeta(Long numero, Date caducidad) {
        this.numero = numero;
        this.caducidad = caducidad;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
