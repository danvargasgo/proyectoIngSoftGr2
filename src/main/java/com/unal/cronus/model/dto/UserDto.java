package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto {
    @Email(message = "Ingrese una dirección de correo eletrónico valida.")
    @NotEmpty(message = "Este campo no puede quedar vacio.")
    private String email;

    @Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑÜü]{1,20}", message = "Este campo debe tener entre 1 y 20 letras.")
    private String name;

    @Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑÜü]{1,20}", message = "Este campo debe tener entre 1 y 20 letras.")
    private String lastName;
    @NotEmpty(message = "Este campo no puede quedar vacio.")
    private String password;
    private String typeUser;
}
