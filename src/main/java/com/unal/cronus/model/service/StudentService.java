package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Student;

public interface StudentService extends GenericService<Student,String>{
    Student searchById(String student_email);
    int numberStudents();
}
