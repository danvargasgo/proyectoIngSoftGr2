package com.unal.cronus.model.entitity;

import com.unal.cronus.model.enums.TypeUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "id_user")
public class Teacher extends User implements Serializable {
    private String faculty;

    public Teacher(String email, String name, String lastName, String password, TypeUser typeUser, String faculty) {
        super(email, name, lastName, password, typeUser);
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return faculty.equals(teacher.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }
}
