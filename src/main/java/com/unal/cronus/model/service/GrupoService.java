package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.entitity.User;

import java.util.List;

public interface GrupoService extends GenericService<Grupo,Integer>{
    /*List<Grupo> searchGruposTeacher(String email_teacher);*/
    List<Grupo> findGrupoByNumber(int number);
    Grupo findByNumberAndSubject(int number, Subject subject);
    void delete(Grupo grupo);
}
