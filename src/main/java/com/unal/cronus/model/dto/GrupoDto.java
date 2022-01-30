package com.unal.cronus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDto {

    private int number;

    private String classroom;

    private String hours;

    private String teacherName;

    private String teacherLastName;

    private int subjectCode;

    private String subjectName;

}
