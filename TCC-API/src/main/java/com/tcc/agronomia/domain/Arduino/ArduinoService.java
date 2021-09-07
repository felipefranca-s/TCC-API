package com.tcc.agronomia.domain.Arduino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ArduinoService {
    @Autowired
    private ArduinoRepository repArduino;

    public Iterable<Arduino> getArduinoDados(){
        return repArduino.findAll();
    }

    public Optional<Arduino> getArduinoDadosById(long id) {
        return repArduino.findById(id);
    }

    public List<Arduino> getArduinoDadosBySensor(String sensor) {
        return repArduino.findBySensor(sensor);
    }

    public Arduino insert(Arduino arduino) {
        return repArduino.save(arduino);
    }

    public Arduino update(Arduino arduino, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Arduino> optional = getArduinoDadosById(id);
        if(optional.isPresent()){
            Arduino db = optional.get();
            db.setSensor(arduino.getSensor());
            db.setValor(arduino.getValor());
            db.setValor2(arduino.getValor2());
            db.setEstado(arduino.getEstado());

            System.out.println("Dados Arduino com ID: "+db.getId());

            repArduino.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<Arduino> optional = getArduinoDadosById(id);
        if(optional.isPresent()){
            repArduino.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }


//    public List<Arduino> getArduino() {
//        List<Arduino> arduinoList = new ArrayList<>();
//
//        arduinoList.add(new Arduino(1L,"sensor1",0.11f,0.101f,true));
//        arduinoList.add(new Arduino(2L,"sensor2",0.12f,0.102f,false));
//        arduinoList.add(new Arduino(3L,"sensor3",0.13f,0.103f,true));
//
//
//        return arduinoList;
//    }

}
