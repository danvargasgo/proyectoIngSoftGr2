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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Grupo> grupos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private List<Question> questions;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
    private List<Student> students;
}
