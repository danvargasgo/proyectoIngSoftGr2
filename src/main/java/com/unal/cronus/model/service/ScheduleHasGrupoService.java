package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.Subject;

public interface ScheduleHasGrupoService {
    void saveScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    void deleteScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    boolean scheduleHasSubject(ScheduleHasGrupo scheduleHasGrupo);
    void deleteAllGruposOfSubjectFromSchedule(Schedule schedule, Subject subject);
}