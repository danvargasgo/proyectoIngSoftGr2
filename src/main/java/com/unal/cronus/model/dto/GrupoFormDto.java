package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoFormDto {

    @NotEmpty
    @Pattern(regexp = "^Edificio \\d{3}, salón \\d{3}$|^No informado$", message = "Este campo debe cumplir con el formato: Edificio 000, salón 000")
    private String classroom;

    @NotEmpty
    @Pattern(regexp ="^[LMWJV]{1}:\\d{1,2}-\\d{1,2};[LMWJV]{1}:\\d{1,2}-\\d{1,2}$", message ="Este campo debe cumplir con el formato: L:7-9;W:7-9" )
    private String hours;


    private Integer subjectCode;

    private Integer number;


}
