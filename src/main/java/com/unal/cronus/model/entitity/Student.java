package com.unal.cronus.model.entitity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unal.cronus.model.enums.TypeUser;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id_user")
@JsonIgnoreProperties({"schedule"})
public class Student extends User implements Serializable {
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "id_schedule"
    )

    private Schedule schedule;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Question> questions;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudentHasSubject> studentHasSubject;
    

    public Student(String email, String name, String lastName, String password, TypeUser typeUser, Schedule schedule) {
        super(email, name, lastName, password, typeUser);
        this.schedule = schedule;
    }
}
