package com.tcc.agronomia.domain.HigrometroDados;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity(name = "higrometro_dados")
public class HigrometroDados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "umidade_solo")
    private int umidadeSolo;

    private Timestamp data;

    @Column(name = "higrometro_id")
    private long higrometroId;
}
