package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.DhtDados.DhtDados;
import com.tcc.agronomia.domain.DhtDados.DhtDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arduino/dhtDados")
public class DhtDadosController {

    @Autowired
    private DhtDadosService dhtDadosService;

    @GetMapping
    public Iterable<DhtDados> get(){
        return dhtDadosService.getDHTDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DhtDados>> get(@PathVariable("id") long id){
        Optional<DhtDados> arduino = dhtDadosService.getDhtDadosById(id);

        if(arduino.isPresent()){
            return ResponseEntity.ok(dhtDadosService.getDhtDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public String post(@RequestBody DhtDados dhtDados){
        DhtDados dhtd = dhtDadosService.insert(dhtDados);
        return "Arduino salvo com sucesso: "+dhtd.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody DhtDados dhtDados, @PathVariable long id){
        dhtDadosService.update(dhtDados, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return dhtDadosService.delete(id);
    }
}
