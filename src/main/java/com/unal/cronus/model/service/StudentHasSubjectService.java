package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.StudentHasSubject;

import java.util.List;

public interface StudentHasSubjectService {
    void saveStudentHasSubject(StudentHasSubject studentHasSubject);
    List<StudentHasSubject> searchByEmail(String email);
    void deleteStudentHasSubject(StudentHasSubject studentHasSubject);
    List<Object[]> searchTop3Subjects();
    int countStudent(int subjectCode);
}
