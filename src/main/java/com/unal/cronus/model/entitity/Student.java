package com.unal.cronus.model.entitity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unal.cronus.model.enums.TypeUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
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

    public Student(String email, String name, String lastName, String password, TypeUser typeUser, Schedule schedule) {
        super(email, name, lastName, password, typeUser);
        this.schedule = schedule;
    }
}
