package com.tcc.agronomia.api;

import com.tcc.agronomia.domain.DHT.ArduinoDHT;
import com.tcc.agronomia.domain.DHT.DHTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/arduino/dht")
public class ArduinoDHTController {

    @Autowired
    private DHTService dhtService;

//    @GetMapping
//    public List<ArduinoDHT> getArduinoFake(){
//        return dhtService.getSensoresDHT();
//    }

    @GetMapping
    public Iterable<ArduinoDHT> get(){
        return dhtService.getDHTDados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ArduinoDHT>> get(@PathVariable("id") long id){
        Optional<ArduinoDHT> arduino = dhtService.getDHTById(id);

        if(arduino.isPresent()){
            return ResponseEntity.ok(dhtService.getDHTById(id));
        }else{
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(service.getUsuariosById(id));
    }
//
//    @GetMapping("/sensor/{sensor}")
//    public ResponseEntity get(@PathVariable("sensor") String sensor){
//        List<Arduino> arduinoList = dhtService.getArduinoDadosBySensor(sensor);
//        return  arduinoList.isEmpty() ?
//                ResponseEntity.noContent().build() :
//                ResponseEntity.ok(arduinoList);
//    }
//
    @PostMapping
    public String post(@RequestBody ArduinoDHT arduino){
        ArduinoDHT ar = dhtService.insert(arduino);
        return "Arduino salvo com sucesso: "+ar.getId();
    }

    @PutMapping("{id}")
    public String put(@RequestBody ArduinoDHT arduino, @PathVariable long id){
        ArduinoDHT ar = dhtService.update(arduino, id);

        return "Arduino atualizado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        return dhtService.delete(id);
    }



}
