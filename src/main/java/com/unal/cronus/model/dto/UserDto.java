package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StudentDto.class, name = "student")
})*/
@NoArgsConstructor
public abstract class UserDto {
    @Email
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String password;
    private String typeUser;
}
