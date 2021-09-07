package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Perfil.Perfil;
import com.tcc.agronomia.domain.Perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/perfil")
public class PerfilController {
    @Autowired
    private PerfilService service;

    @GetMapping
    public ResponseEntity<Iterable<Perfil>> get(){
        return new ResponseEntity<>(service.getPerfilDados(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Perfil>> get(@PathVariable("id") long id){
        Optional<Perfil> usuario = service.getPerfilDadosById(id);

        if(usuario.isPresent()){
            return ResponseEntity.ok(service.getPerfilDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }

    @PostMapping
    public String post(@RequestBody Perfil perfil){
        Perfil u = service.insert(perfil);
        return "Perfil salvo com sucesso: "+u.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody Perfil perfil, @PathVariable long id){
        Perfil user = service.update(perfil, id);
        return "Perfil atualizado com sucesso: "+user.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return service.delete(id);
    }
}