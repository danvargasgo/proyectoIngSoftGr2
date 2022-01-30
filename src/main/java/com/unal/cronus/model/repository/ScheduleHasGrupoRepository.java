package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.LlaveScheduleHasGrupo;
import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleHasGrupoRepository extends JpaRepository<ScheduleHasGrupo, LlaveScheduleHasGrupo>{

    @Query(value = "SELECT * FROM schedule_has_grupo WHERE id_schedule=:scheduleId AND grupo_subject_code=:subjectCode",nativeQuery = true)
    public ScheduleHasGrupo scheduleHasSubject(@Param("scheduleId") int scheduleId,@Param("subjectCode") int SubjectCode);


}