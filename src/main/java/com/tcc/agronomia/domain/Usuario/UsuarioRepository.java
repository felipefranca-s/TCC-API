package com.tcc.agronomia.domain.Usuario;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    List<Usuario> findByPerfilId(String perfilId);
}
