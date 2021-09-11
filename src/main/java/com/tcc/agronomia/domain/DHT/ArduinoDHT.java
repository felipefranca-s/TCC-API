package com.tcc.agronomia.domain.DHT;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity(name = "arduino_dht")
public class ArduinoDHT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_arduino")
    private long idArduino;

    @Column(name = "umidade_ar")
    private int umidadeAr;

    private String nome;
    private float temperatura;
    private boolean estado;

}
