package com.tcc.agronomia.domain.Grupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository rep;

    public Iterable<Grupo> getGrupoDados(){
        return rep.findAll();
    }

    public Optional<Grupo> getGrupoDadosById(long id) {
        return rep.findById(id);
    }

    public Grupo insert(Grupo grupo) {
        return rep.save(grupo);
    }

    public Grupo update(Grupo grupo, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Grupo> optional = getGrupoDadosById(id);
        if(optional.isPresent()){
            Grupo db = optional.get();
            db.setNome(grupo.getNome());
            db.setAtivo(grupo.isAtivo());

            System.out.println("Dados do Grupo com ID: "+db.getId());

            rep.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<Grupo> optional = getGrupoDadosById(id);
        if(optional.isPresent()){
            rep.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }
}
