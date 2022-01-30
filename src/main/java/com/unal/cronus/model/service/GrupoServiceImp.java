package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Grupo;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoServiceImp implements GrupoService{
    @Autowired
    GrupoRepository grupoRepository;

    /*@Override
    public List<Grupo> searchGruposTeacher(String email_teacher) {
        return grupoRepository.searchGruposTeacher(email_teacher);
    }*/
    @Override
    @Transactional(readOnly = true)
    public List<Grupo> findGrupoByNumber(int number) {
        return grupoRepository.findGrupoByNumber(number);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grupo> findById(Integer id) {
        return grupoRepository.findById(id);
    }

    @Override
    @Transactional
    public Grupo save(Grupo entidad) {
        return grupoRepository.save(entidad);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        grupoRepository.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public Grupo findByNumberAndSubject(int number, Subject subjectCode) {
        return grupoRepository.findByNumberAndSubject(number,subjectCode);
    }

    @Override
    @Transactional
    public void delete(Grupo enity) {
        grupoRepository.delete(enity);

    }
}
