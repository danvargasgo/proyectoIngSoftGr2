package com.unal.cronus.model.entitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grupo")
@IdClass(LlaveGrupo.class)
public class Grupo implements Serializable {
    @Id
    private int number;

    private String classroom;

    private String hours;

    @Id
    @ManyToOne
    @JoinColumn(name = "subject_code", nullable = false, updatable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_email", nullable = false, updatable = false)
    private Teacher teacher;

    //Relacion de uno a muchos con la tabla student_has_subject
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<ScheduleHasGrupo> scheduleHasGrupo;

    public Grupo(int number, String classroom, String hours, Subject subject, Teacher teacher) {
        this.number = number;
        this.classroom = classroom;
        this.hours = hours;
        this.subject = subject;
        this.teacher = teacher;
    }
}
