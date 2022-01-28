package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    @Query(value ="SELECT * FROM grupo WHERE teacher_email = :teacher_email",
            nativeQuery = true)
    List<Grupo> searchGruposTeacher(@Param("teacher_email") String teacher_email);
}
