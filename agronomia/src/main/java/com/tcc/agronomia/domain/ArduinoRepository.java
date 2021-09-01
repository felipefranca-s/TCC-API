package com.tcc.agronomia.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArduinoRepository extends CrudRepository<Arduino,Long> {
    List<Arduino> findBySensor(String sensor);
}
