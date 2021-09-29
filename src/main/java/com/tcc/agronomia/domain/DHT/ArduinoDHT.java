package com.tcc.agronomia.domain.DHT;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity(name = "arduino_dht")
public class ArduinoDHT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private float temperatura;
    private boolean estado;

    @Column(name = "umidade_ar")
    private int umidadeAr;

    @Column(name = "id_arduino")
    private long idArduino;



}
