package com.tcc.agronomia.domain.personalizado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonalizadoRepository extends JpaRepository<PlantilGrupo,Long> {

    @Query(value = "SELECT p.id,p.nome,p.ativo,g.nome as grupo FROM plantacao p JOIN grupo g ON g.Id = p.grupo_id WHERE 1", nativeQuery = true)
    Iterable<PlantilGrupo> findJoin();
}
