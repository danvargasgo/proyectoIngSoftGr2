package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImp implements GrupoService{
    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public List<Grupo> searchGruposTeacher(String email_teacher) {
        return grupoRepository.searchGruposTeacher(email_teacher);
    }
}
