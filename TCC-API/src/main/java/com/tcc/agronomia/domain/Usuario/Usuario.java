package com.tcc.agronomia.domain.Usuario;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;
    private String ativo;

    @Column(name = "perfil_id")
    private String perfilId;
}
