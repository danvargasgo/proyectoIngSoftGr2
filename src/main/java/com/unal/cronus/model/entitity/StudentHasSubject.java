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
@Table(name= "student_has_subject")
@IdClass(LlaveStudentHasSubject.class)
public class StudentHasSubject implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_email", nullable = false)
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "subject_code", nullable = false)
    private Subject subject;


}
