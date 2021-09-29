package com.tcc.agronomia.domain.PlantilGrupo;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class PlantilGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nomePlantil;

    private boolean ativo;

    @Column(name = "grupo")
    private String nomeGrupo;
}
