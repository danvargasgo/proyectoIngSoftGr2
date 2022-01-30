package com.unal.cronus.model.entitity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class LlaveGrupo implements Serializable {
    private int number;
    private int subject;
}
