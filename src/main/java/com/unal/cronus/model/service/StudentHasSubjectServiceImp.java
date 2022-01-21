package com.unal.cronus.model.service;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.service.StudentHasSubjectService;

public class StudentHasSubjectServiceImp implements StudentHasSubjectService{
    @Override
    public void saveStudentHasSubject(StudentHasSubject studentHasSubject) {
       studentHasSubjectRepository.save(studentHasSubject);
    }

    @Override
    public List<StudentHasSubject> searchByEmail(String email) {
        return studentHasSubjectRepository.searchByEmail(email);
    }


}
