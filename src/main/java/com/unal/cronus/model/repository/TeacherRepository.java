package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,String> {
}
