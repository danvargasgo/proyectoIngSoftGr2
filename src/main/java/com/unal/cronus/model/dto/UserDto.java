package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto {
    @Email(message = "Ingrese una dirección de correo eletrónico valida.")
    @NotEmpty(message = "Este campo no puede quedar vacio.")
    private String email;

    @Size(min = 2,max = 20,message = "Este campo debe tener mas de 3 letras y menos de 20.")
    private String name;

    @Size(min = 2,max = 20,message = "Este campo debe tener mas de 3 letras y menos de 20.")
    private String lastName;
    @NotEmpty(message = "Este campo no puede quedar vacio.")
    private String password;
    private String typeUser;
}
