package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Teacher;
import com.unal.cronus.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {


    @Autowired
    TeacherRepository teacherRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Teacher> findById(String id) {
        return teacherRepository.findById(id) ;
    }

    @Override
    @Transactional()
    public Teacher save(Teacher entidad) {
        return teacherRepository.save(entidad);
    }

    @Override
    @Transactional()
    public void deleteById(String id) {
        teacherRepository.deleteById(id);
    }
}
