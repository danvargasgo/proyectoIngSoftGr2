package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.LlaveGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoNicheRespository extends JpaRepository<Grupo, LlaveGrupo> {

    @Query(value = "SELECT * FROM grupo WHERE number=:number AND subject_code=:subjectCode", nativeQuery = true)
    public Grupo searchGrupoByNumberAndSubjectCode(@Param("number") int number, @Param("subjectCode") int subjectCode) ;

}
