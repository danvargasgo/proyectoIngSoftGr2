package com.unal.cronus.model.entitity;

import com.unal.cronus.model.enums.TypeUser;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "id_user")
public class Teacher extends User implements Serializable {
    private String faculty;

    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "teacher",fetch = FetchType.EAGER)
    private List<Grupo> grupos;

    public Teacher(String email, String name, String lastName, String password, TypeUser typeUser, String faculty) {
        super(email, name, lastName, password, typeUser);
        this.faculty = faculty;
    }
}
