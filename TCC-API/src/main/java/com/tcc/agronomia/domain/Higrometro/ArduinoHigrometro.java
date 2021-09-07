package com.tcc.agronomia.domain.Higrometro;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "arduino_higrometro")
@Data
public class ArduinoHigrometro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_arduino")
    private long idArduino;

    @Column(name = "umidade_solo")
    private int umidadeSolo;

    private String nome;
    private boolean estado;

}
