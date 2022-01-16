package com.unal.cronus.model.dto;

import com.unal.cronus.security.ValitationEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UserDto {
    @Email(message = "Ingrese una dirección de correo electrónico válida.")
    @NotEmpty(message = "Este campo no puede quedar vacío.")
    @ValitationEmail
    private String email;

    @Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑÜü]{1,20} {0,1}[a-zA-Zá-úÁ-ÚñÑÜü]{0,20}", message = "Este campo debe tener entre 1 y 40 letras.")
    private String name;

    @Pattern(regexp = "[a-zA-Zá-úÁ-ÚñÑÜü]{1,20} {0,1}[a-zA-Zá-úÁ-ÚñÑÜü]{0,20}", message = "Este campo debe tener entre 1 y 40 letras.")
    private String lastName;
    @NotEmpty(message = "Este campo no puede quedar vacío.")
    private String password;
    private String typeUser;
}
