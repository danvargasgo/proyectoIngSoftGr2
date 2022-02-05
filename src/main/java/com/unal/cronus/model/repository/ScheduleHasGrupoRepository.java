package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.LlaveScheduleHasGrupo;
import com.unal.cronus.model.entitity.ScheduleHasGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ScheduleHasGrupoRepository extends JpaRepository<ScheduleHasGrupo, LlaveScheduleHasGrupo>{

    @Query(value = "SELECT * FROM schedule_has_grupo WHERE id_schedule=:scheduleId AND grupo_subject_code=:subjectCode",nativeQuery = true)
    ScheduleHasGrupo scheduleHasSubject(@Param("scheduleId") int scheduleId,@Param("subjectCode") int SubjectCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule_has_grupo WHERE id_schedule=:scheduleId AND grupo_subject_code=:subjectCode",nativeQuery = true)
    void deleteScheduleHasGrupo (@Param("scheduleId") int scheduleId,@Param("subjectCode") int SubjectCode);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule_has_grupo WHERE grupo_number=:numberGrupo AND grupo_subject_code=:subjectCode",nativeQuery = true)
    void deleteGrupoOnAllSchedules(@Param("numberGrupo")int numberGrupo, @Param("subjectCode")int subjectCode);

    @Query(value = "SELECT sum(credits) FROM schedule_has_grupo join subject on grupo_subject_code = code;", nativeQuery = true)
    int sumCredits();

    @Query(value = "SELECT count(grupo_subject_code) FROM schedule_has_grupo;", nativeQuery = true)
    int countSubjects();

    @Query(value = "select grupo_number, count(grupo_number), concat(name,' ',last_name) from schedule_has_grupo join grupo on grupo_subject_code = subject_code and grupo_number = number join user on teacher_email = email where subject_code = :subjectCode group by grupo_number order by count(grupo_number) desc", nativeQuery = true)
    List<Object[]> selectedGroups(@Param("subjectCode") int subjectCode);
}