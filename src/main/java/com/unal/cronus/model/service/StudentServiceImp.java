package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;


    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student user) {
        return studentRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
