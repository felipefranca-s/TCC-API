package com.tcc.agronomia.domain.Plantacao;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
public class Plantacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "grupo_id")
    private long grupoID;

    private String nome;
    private boolean ativo;

}
