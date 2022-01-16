package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query(value ="SELECT * FROM subject WHERE name LIKE %:keyword%",
            nativeQuery = true)
    List<Subject> searchSubjectsByName(@Param("keyword") String keyword);

    @Query(value ="SELECT * FROM subject WHERE code = :code",
            nativeQuery = true)
    Subject searchSubjectsByCode(@Param("code") int code);
}
