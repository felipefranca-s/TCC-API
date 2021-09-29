package com.tcc.agronomia.domain.Perfil;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private boolean ativo;

}
