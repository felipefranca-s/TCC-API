package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Higrometro.ArduinoHigrometro;
import com.tcc.agronomia.domain.Higrometro.HigrometroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arduino/higrometro")
public class HigrometroController {

    @Autowired
    private HigrometroService higrometroService;

    @GetMapping
    public Iterable<ArduinoHigrometro> getHigrometros(){
        return higrometroService.getArduinoDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ArduinoHigrometro>> getHigrometroById(@PathVariable("id") long id){
        Optional<ArduinoHigrometro> arduino = higrometroService.getArduinoDadosById(id);

        if(arduino.isPresent()){
            return ResponseEntity.ok(higrometroService.getArduinoDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }

    @PostMapping
    public String post(@RequestBody ArduinoHigrometro arduino){
        ArduinoHigrometro ar = higrometroService.insert(arduino);
        return "Arduino salvo com sucesso: "+ar.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody ArduinoHigrometro arduino, @PathVariable long id){
        ArduinoHigrometro ar = higrometroService.update(arduino, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return higrometroService.delete(id);
    }

}