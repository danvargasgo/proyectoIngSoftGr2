package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import com.unal.cronus.model.entitity.Subject;
import com.unal.cronus.model.repository.ScheduleHasGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteAllGruposOfSubjectFromSchedule(Schedule schedule, Subject subject) {
        scheduleHasGrupoRepository.deleteScheduleHasGrupo(schedule.getIdSchedule(), subject.getCode());
    }

    @Override
    public void deleteGrupoOnAllSchedules(int numberGrupo, int subjectCode) {
        scheduleHasGrupoRepository.deleteGrupoOnAllSchedules(numberGrupo, subjectCode);
    }

    @Override
    public int sumCredits() {
        return scheduleHasGrupoRepository.sumCredits();
    }

    @Override
    public int countSubjects() {
        return scheduleHasGrupoRepository.countSubjects();
    }

    @Override
    public List<Object[]> selectedGroups(int subjectCode) {
        return scheduleHasGrupoRepository.selectedGroups(subjectCode);
    }
}