package com.tcc.agronomia.domain.Arduino;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Arduino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean atuador;
    private String  nome;

    @Column(name = "plantacao_id")
    private long   plantacaoID;


}
