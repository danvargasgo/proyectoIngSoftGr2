package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Integer > {

    /*@Query(value ="SELECT * FROM grupo WHERE teacher_email = :teacher_email",
            nativeQuery = true)
    List<Grupo> searchGruposTeacher(@Param("teacher_email") String teacher_email);*/
    List<Grupo> findGrupoByNumber(int number);
    Grupo findByNumberAndSubject(int number, Subject subject);

}
