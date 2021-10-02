package com.tcc.agronomia.domain.HigrometroDados;

import com.tcc.agronomia.domain.HigrometroDados.HigrometroDados;
import com.tcc.agronomia.domain.HigrometroDados.HigrometroDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class HigrometroDadosService {

    @Autowired
    private HigrometroDadosRepository rep;

    public Iterable<HigrometroDados> getHigrometroDados() {
        return rep.findAll();
    }

    public Optional<HigrometroDados> getHigrometroDadosById(long id) {
        return rep.findById(id);
    }

    public HigrometroDados insert(HigrometroDados arduino) {
        return rep.save(arduino);
    }

    public HigrometroDados update(HigrometroDados arduino, long id) {
        Assert.notNull(getHigrometroDadosById(id), "Não foi possivel atualizar o registro!");

        Optional<HigrometroDados> higrometroDados = getHigrometroDadosById(id);
        if (higrometroDados.isPresent()) {
            HigrometroDados db = higrometroDados.get();
            db.setId(arduino.getId());
            db.setUmidadeSolo(arduino.getUmidadeSolo());
            db.setData(arduino.getData());
            db.setHigrometroId(arduino.getHigrometroId());

            System.out.println("Dados do sensor Higrometro atualizados com sucesso! " + db.getId());

            rep.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possivel atualizar o registro!");
        }
    }

    public String delete(long id) {
        Optional<HigrometroDados> higrometro = getHigrometroDadosById(id);
        if (higrometro.isPresent()) {
            rep.delete(higrometro.get());
            return "Registro deletado com sucesso: " + higrometro.get().getId();
        } else {
            throw new RuntimeException("Não foi possivel deletar o registro");
        }
    }
}
