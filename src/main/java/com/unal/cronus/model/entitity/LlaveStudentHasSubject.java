package com.unal.cronus.model.entitity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class LlaveStudentHasSubject implements Serializable {
    
    private Student student;
    private Subject subject;
}
