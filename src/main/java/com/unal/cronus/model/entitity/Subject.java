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
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    private int code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String credits;

    private String description;

    private String prerequisite;

    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "subject")
    private List<Grupo> grupos;

    //Relacion de uno a muchos con la tabla student_has_subject
    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "subject")
    private List<StudentHasSubject> studentHasSubject;

    public Subject(int code, String name, String credits, String description, String prerequisite) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.description = description;
        this.prerequisite = prerequisite;
    }
}
