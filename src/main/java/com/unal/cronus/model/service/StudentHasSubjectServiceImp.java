package com.unal.cronus.model.service;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.repository.StudentHasSubjectRepository;
import com.unal.cronus.model.service.StudentHasSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHasSubjectServiceImp implements StudentHasSubjectService{

    @Autowired
    StudentHasSubjectRepository studentHasSubjectRepository;

    @Override
    public void saveStudentHasSubject(StudentHasSubject studentHasSubject) {
       studentHasSubjectRepository.save(studentHasSubject);
    }

    @Override
    public List<StudentHasSubject> searchByEmail(String email) {
        return studentHasSubjectRepository.searchByEmail(email);
    }

    @Override
    public void deleteStudentHasSubject(StudentHasSubject studentHasSubject) {
        studentHasSubjectRepository.delete(studentHasSubject);
    }

    @Override
    public List<Object[]> searchTop3Subjects() {
        return studentHasSubjectRepository.searchTop3Subjects();
    }

    @Override
    public int countStudent(int subjectCode) {
        return studentHasSubjectRepository.countStudent(subjectCode);
    }

}
