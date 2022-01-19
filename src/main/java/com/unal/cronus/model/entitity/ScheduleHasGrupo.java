package com.unal.cronus.model.entitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "schedule_has_grupo")
@IdClass(LlaveScheduleHasGrupo.class)
public class ScheduleHasGrupo implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false, updatable = false)
    private Schedule schedule;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "grupo_number", referencedColumnName = "number", nullable = false, updatable = false),
            @JoinColumn(name = "grupo_subject_code", referencedColumnName = "subject_code", nullable = false, updatable = false)
    })
    private Grupo grupo;

}
