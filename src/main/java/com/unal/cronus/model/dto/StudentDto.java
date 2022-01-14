package com.unal.cronus.model.dto;

import org.springframework.data.repository.NoRepositoryBean;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoRepositoryBean
public class StudentDto extends UserDto {
    public StudentDto( String email, @NotEmpty String name, @NotEmpty String lastName, @NotEmpty String password, String typeUser) {
        super(email, name, lastName, password, typeUser);
    }

    public StudentDto() {
    }
}
