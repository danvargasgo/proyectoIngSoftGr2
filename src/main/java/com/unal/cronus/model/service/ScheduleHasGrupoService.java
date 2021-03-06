package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.Schedule;
import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import com.unal.cronus.model.entitity.StudentHasSubject;
import com.unal.cronus.model.entitity.Subject;

import java.util.List;

public interface ScheduleHasGrupoService {
    void saveScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    void deleteScheduleHasGrupo(ScheduleHasGrupo scheduleHasGrupo);
    boolean scheduleHasSubject(ScheduleHasGrupo scheduleHasGrupo);
    void deleteAllGruposOfSubjectFromSchedule(Schedule schedule, Subject subject);
    void deleteGrupoOnAllSchedules(int numberGrupo, int subjectCode);
    int sumCredits();
    int countSubjects();
    List<Object[]> selectedGroups(int subjectCode);
}