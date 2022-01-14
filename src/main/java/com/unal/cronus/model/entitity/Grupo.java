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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "grupos")
    private List<Schedule> schedules;
}
