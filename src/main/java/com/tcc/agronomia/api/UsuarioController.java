package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Usuario.Usuario;
import com.tcc.agronomia.domain.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;


    @GetMapping
    public ResponseEntity<Iterable<Usuario>> get(){
        return new ResponseEntity<>(service.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> get(@PathVariable("id") long id){
        Optional<Usuario> usuario = service.getUsuariosById(id);

        if(usuario.isPresent()){
            return ResponseEntity.ok(service.getUsuariosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.ok(service.getUsuariosById(id));
    }

    @PostMapping
    public String post(@RequestBody Usuario usuario){
        Usuario u = service.insert(usuario);
        return "Usuario salvo com sucesso: "+u.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody Usuario usuario, @PathVariable long id){
        Usuario user = service.update(usuario, id);
        return "Usuário atualizado com sucesso: "+user.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return service.delete(id);
    }
}