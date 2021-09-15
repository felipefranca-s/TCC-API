package com.tcc.agronomia.domain.personalizado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantilGrupoService {
    @Autowired
    private PersonalizadoRepository repository;

    public Iterable<PlantilGrupo> getJoinPlantilGrupo(){
        return repository.findJoin();
    }

}
