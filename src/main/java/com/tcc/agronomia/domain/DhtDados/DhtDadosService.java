package com.tcc.agronomia.domain.DhtDados;

import com.tcc.agronomia.domain.DHT.ArduinoDHT;
import com.tcc.agronomia.domain.DHT.DHTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class DhtDadosService {

    @Autowired
    private DhtDadosRepository rep;

    public Iterable<DhtDados> getDHTDados() {
        return rep.findAll();
    }

    public Optional<DhtDados> getDhtDadosById(long id) {
        return rep.findById(id);
    }

    public DhtDados insert(DhtDados arduino) {
        return rep.save(arduino);
    }

    public DhtDados update(DhtDados arduino, long id) {
        Assert.notNull(getDhtDadosById(id), "Não foi possivel atualizar o registro!");

        Optional<DhtDados> dhtDados = getDhtDadosById(id);
        if (dhtDados.isPresent()) {
            DhtDados db = dhtDados.get();
            db.setId(arduino.getId());
            db.setTemperatura(arduino.getTemperatura());
            db.setUmidadeAr(arduino.getUmidadeAr());
            db.setData(arduino.getData());
            db.setDhtId(arduino.getDhtId());


            System.out.println("Dados do sensor DHT atualizados com sucesso! " + db.getId());

            rep.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possivel atualizar o registro!");
        }
    }

    public String delete(long id) {
        Optional<DhtDados> dht = getDhtDadosById(id);
        if (dht.isPresent()) {
            rep.delete(dht.get());
            return "Registro deletado com sucesso: " + dht.get().getId();
        } else {
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }
}
