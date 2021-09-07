package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Grupo.Grupo;
import com.tcc.agronomia.domain.Grupo.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/grupo")
public class GrupoController {

    @Autowired
    private GrupoService serviceGrupo;

    @GetMapping
    public Iterable<Grupo> get(){
        return serviceGrupo.getGrupoDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Grupo>> get(@PathVariable("id") long id){
        Optional<Grupo> grupo = serviceGrupo.getGrupoDadosById(id);

        if(grupo.isPresent()){
            return ResponseEntity.ok(serviceGrupo.getGrupoDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }

    @PostMapping
    public String post(@RequestBody Grupo grupo){
        Grupo ar = serviceGrupo.insert(grupo);
        return "Grupo salvo com sucesso: "+ar.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody Grupo grupo, @PathVariable long id){
        Grupo ar = serviceGrupo.update(grupo, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return serviceGrupo.delete(id);
    }

}
