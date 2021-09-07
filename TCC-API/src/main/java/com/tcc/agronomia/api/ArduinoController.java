package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.Arduino.Arduino;
import com.tcc.agronomia.domain.Arduino.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arduino")
public class ArduinoController {

    @Autowired
    private ArduinoService serviceArduino;

    @GetMapping
    public Iterable<Arduino> get(){
        return serviceArduino.getArduinoDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Arduino>> get(@PathVariable("id") long id){
        Optional<Arduino> arduino = serviceArduino.getArduinoDadosById(id);

        if(arduino.isPresent()){
            return ResponseEntity.ok(serviceArduino.getArduinoDadosById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }

    @GetMapping("/sensor/{sensor}")
    public ResponseEntity get(@PathVariable("sensor") String sensor){
        List<Arduino> arduinoList = serviceArduino.getArduinoDadosBySensor(sensor);
        return  arduinoList.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(arduinoList);
    }

    @PostMapping
    public String post(@RequestBody Arduino arduino){
        Arduino ar = serviceArduino.insert(arduino);
        return "Arduino salvo com sucesso: "+ar.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody Arduino arduino, @PathVariable long id){
        Arduino ar = serviceArduino.update(arduino, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return serviceArduino.delete(id);
    }
//    @GetMapping
//    public List<Arduino> getArduinoFake(){
//        return serviceArduino.getArduino();
//    }

}
