package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.HigrometroDados.HigrometroDados;
import com.tcc.agronomia.domain.HigrometroDados.HigrometroDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arduino/higrometroDados")
public class HigrometroDadosController {

    @Autowired
    private HigrometroDadosService higrometroDadosService;

    @GetMapping
    public Iterable<HigrometroDados> get(){
        return higrometroDadosService.getHigrometroDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HigrometroDados>> get(@PathVariable("id") long id){
        Optional<HigrometroDados> arduino = higrometroDadosService.getHigrometroDadosById(id);

        if(arduino.isPresent()){
            return ResponseEntity.ok(higrometroDadosService.getHigrometroDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public String post(@RequestBody HigrometroDados higrometroDados){
        HigrometroDados higd = higrometroDadosService.insert(higrometroDados);
        return "Arduino salvo com sucesso: "+higd.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody HigrometroDados higrometroDados, @PathVariable long id){
        higrometroDadosService.update(higrometroDados, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return higrometroDadosService.delete(id);
    }
}
