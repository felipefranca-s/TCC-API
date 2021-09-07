package com.tcc.agronomia.domain.Perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public Iterable<Perfil> getPerfilDados(){
        return repository.findAll();
    }

    public Optional<Perfil> getPerfilDadosById(long id) {
        return repository.findById(id);
    }

    public Perfil insert(Perfil perfil) {
        return repository.save(perfil);
    }

    public Perfil update(Perfil perfil, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Perfil> optional = getPerfilDadosById(id);
        if(optional.isPresent()){
            Perfil db = optional.get();
            db.setNome(perfil.getNome());
            db.setAtivo(perfil.isAtivo());

            System.out.println("Dados do Perfil ID"+db.getId()+" foi atualizado com sucesso!");

            repository.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<Perfil> optional = getPerfilDadosById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }

}
