package com.tcc.agronomia.domain.Arduino;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Arduino {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private boolean atuador;
    private String  nome;

    @Column(name = "plantacao_id")
    private long   plantacaoID;

}
