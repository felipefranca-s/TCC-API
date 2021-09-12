package com.tcc.agronomia.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;

    public Iterable<Usuario> getUsuarios() {
        return rep.findAll();
    }

    public Optional<Usuario> getUsuariosById(long id) {
        return rep.findById(id);
    }

    public Usuario insert(Usuario usuario) {
        return rep.save(usuario);
    }

    public Usuario update(Usuario usuario, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Usuario> optional = getUsuariosById(id);
        if(optional.isPresent()){
            Usuario db = optional.get();
            db.setNome(usuario.getNome());
            db.setEmail(usuario.getEmail());
            db.setSenha(usuario.getSenha());
            db.setPerfilId(usuario.getPerfilId());
            db.setAtivo(usuario.isAtivo());
            db.setGrupoId(usuario.getGrupoId());

            System.out.println("Usuario ID: "+db.getId());

            rep.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }

    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<Usuario> optional = getUsuariosById(id);
        if(optional.isPresent()){
            rep.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }
}
