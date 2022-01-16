package com.unal.cronus.model.entitity;

import com.unal.cronus.model.enums.TypeUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id_user")
public class Admin extends User implements Serializable {

    public Admin(String email, String name, String lastName, String password, TypeUser typeUser) {
        super(email, name, lastName, password, typeUser);
    }
}
