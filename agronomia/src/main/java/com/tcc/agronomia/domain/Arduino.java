package com.tcc.agronomia.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Arduino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String  sensor;
    private float   valor;
    private float   valor2;
    private boolean estado;

    public boolean getEstado() {
        return estado;
    }
}
