package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Schedule> findById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    @Transactional
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        scheduleRepository.deleteById(id);
    }
}
