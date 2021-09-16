package com.tcc.agronomia.api;


import com.tcc.agronomia.domain.PlantilGrupo.PlantilGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plantilGrupo")
public class PlantilGrupoController {

    @Autowired
    private PlantilGrupoService serviceJoin;

    @GetMapping
    public Iterable<com.tcc.agronomia.domain.PlantilGrupo.PlantilGrupo> get(){
        return serviceJoin.getJoinPlantilGrupo();
    }
}
