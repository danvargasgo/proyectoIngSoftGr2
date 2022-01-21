package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.LlaveStudentHasSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject,LlaveStudentHasSubject> {
}
