package com.unal.cronus.model.entitity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "question")
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "student_email", nullable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_email", nullable = false, updatable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_code", nullable = false, updatable = false)
    private Subject subject;
}
