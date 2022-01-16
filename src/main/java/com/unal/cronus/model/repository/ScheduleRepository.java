package com.unal.cronus.model.repository;
import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
