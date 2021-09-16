package com.tcc.agronomia.domain.PlantilGrupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantilGrupoService {
    @Autowired
    private PlantilGrupoRepository repository;

    public Iterable<PlantilGrupo> getJoinPlantilGrupo(){
        return repository.findJoin();
    }

}
