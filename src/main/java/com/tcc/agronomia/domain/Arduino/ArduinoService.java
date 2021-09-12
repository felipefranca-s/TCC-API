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

    public Arduino insert(Arduino arduino) {
        return repArduino.save(arduino);
    }

    public Arduino update(Arduino arduino, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<Arduino> optional = getArduinoDadosById(id);
        if(optional.isPresent()){
            Arduino db = optional.get();
            db.setAtuador(arduino.isAtuador());
            db.setNome(arduino.getNome());
            db.setPlantacaoID(arduino.getPlantacaoID());

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

}
