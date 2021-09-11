package com.tcc.agronomia.domain.Plantacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class PlantacaoService {

    @Autowired
    private PlantacaoRepository repository;

    public Iterable<Plantacao> getPlantilDados(){
        return repository.findAll();
    }

    public Optional<Plantacao> getPlantilDadosById(long id) {
        return repository.findById(id);
    }

    public Plantacao insert(Plantacao plantil) {
        return repository.save(plantil);
    }

    public Plantacao update(Plantacao plantil, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Plantacao> optional = getPlantilDadosById(id);
        if(optional.isPresent()){
            Plantacao db = optional.get();
            db.setNome(plantil.getNome());
            db.setGrupoID(plantil.getGrupoID());
            db.setAtivo(plantil.isAtivo());

            System.out.println("Dados do Higrometro com ID: "+db.getId());

            repository.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<Plantacao> optional = getPlantilDadosById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }

}
