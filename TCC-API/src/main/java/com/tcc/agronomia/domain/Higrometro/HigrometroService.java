package com.tcc.agronomia.domain.Higrometro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class HigrometroService {

    @Autowired
    private HigrometroRepository repository;

    public Iterable<ArduinoHigrometro> getArduinoDados(){
        return repository.findAll();
    }

    public Optional<ArduinoHigrometro> getArduinoDadosById(long id) {
        return repository.findById(id);
    }

    public ArduinoHigrometro insert(ArduinoHigrometro arduino) {
        return repository.save(arduino);
    }

    public ArduinoHigrometro update(ArduinoHigrometro arduino, long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        Optional<ArduinoHigrometro> optional = getArduinoDadosById(id);
        if(optional.isPresent()){
            ArduinoHigrometro db = optional.get();
            db.setNome(arduino.getNome());
            db.setUmidadeSolo(arduino.getUmidadeSolo());
            db.setIdArduino(arduino.getIdArduino());
            db.setEstado(arduino.isEstado());

            System.out.println("Dados do Higrometro com ID: "+db.getId());

            repository.save(db);

            return db;
        }else{
            throw new RuntimeException("Não foi possivel atualizar o registro");
        }
    }

    public String delete(long id) {
        Assert.notNull(id, "Não foi possivel deletar o registro");

        Optional<ArduinoHigrometro> optional = getArduinoDadosById(id);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "Registro deletado com sucesso: "+optional.get().getId();
        }else{
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }

}
