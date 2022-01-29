package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDto {
    @NotEmpty
    private String classroom;
    @NotEmpty
    private String hours;


    private Integer subjectCode;

    private Integer number;

}
