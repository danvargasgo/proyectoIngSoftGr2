package com.unal.cronus.model.entitity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unal.cronus.model.enums.TypeUser;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Serializable {
    @Id
    private String email;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "ENUM('ADMIN','STUDENT','TEACHER')")
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    public User(String email, String name, String lastName, String password, TypeUser typeUser) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.typeUser = typeUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
