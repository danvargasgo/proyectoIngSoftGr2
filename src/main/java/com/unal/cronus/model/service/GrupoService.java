package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Grupo;

import java.util.List;

public interface GrupoService {
    List<Grupo> searchGruposTeacher(String email_teacher);
}
