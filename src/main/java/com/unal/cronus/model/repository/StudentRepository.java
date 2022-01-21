package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Student;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Query(value="SELECT * FROM student join user on id_user=email WHERE email = :email", nativeQuery = true)
    Student searchById(@Param("email") String email);
}
