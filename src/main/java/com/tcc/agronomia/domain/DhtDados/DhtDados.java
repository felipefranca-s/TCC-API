package com.tcc.agronomia.domain.DhtDados;

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
@Entity(name = "dht_dados")
public class DhtDados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float temperatura;

    @Column(name = "umidade_ar")
    private int umidadeAr;

    private Timestamp data;

    @Column(name = "dht_id")
    private long dhtId;
}
