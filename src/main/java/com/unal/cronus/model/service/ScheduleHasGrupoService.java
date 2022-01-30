package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import com.unal.cronus.model.entitity.StudentHasSubject;

public interface ScheduleHasGrupoService {
    void saveScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    void deleteScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    boolean scheduleHasSubject(ScheduleHasGrupo scheduleHasGrupo);
}