package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.LlaveStudentHasSubject;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentHasSubjectRepository extends JpaRepository<StudentHasSubject,LlaveStudentHasSubject>{

    @Query(value="SELECT * FROM student_has_subject where student_email = :email",
        nativeQuery= true)
    List<StudentHasSubject> searchByEmail(@Param("email") String email);
}
