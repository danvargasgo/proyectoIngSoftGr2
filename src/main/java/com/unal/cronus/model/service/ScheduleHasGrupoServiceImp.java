package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import com.unal.cronus.model.repository.ScheduleHasGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleHasGrupoServiceImp implements ScheduleHasGrupoService {
    @Autowired
    ScheduleHasGrupoRepository scheduleHasGrupoRepository;
    @Override
    public void saveScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo) {
        scheduleHasGrupoRepository.save(scheduleHasGrupo);
    }

    @Override
    public void deleteScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo) {
        scheduleHasGrupoRepository.delete(scheduleHasGrupo);
    }

    @Override
    public boolean scheduleHasSubject(ScheduleHasGrupo scheduleHasGrupo) {
        return scheduleHasGrupoRepository.scheduleHasSubject(scheduleHasGrupo.getSchedule().getIdSchedule(), scheduleHasGrupo.getGrupo().getSubject().getCode()) != null;
    }
}