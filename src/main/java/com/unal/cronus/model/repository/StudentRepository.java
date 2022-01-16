package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.entitity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value ="SELECT * FROM student_has_subject where student_email=:studentEmail AND subject_code=subjectCode",
            nativeQuery = true)
    Object searchSubjectsByName(@Param("studentEmail") String studentEmail, @Param("subjectCode") int subjectCode);
}
