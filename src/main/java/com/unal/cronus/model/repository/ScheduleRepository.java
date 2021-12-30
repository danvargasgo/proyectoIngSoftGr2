package com.unal.cronus.model.repository;
import com.unal.cronus.model.entitity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
