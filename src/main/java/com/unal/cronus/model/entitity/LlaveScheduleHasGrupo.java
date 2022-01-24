package com.unal.cronus.model.entitity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class LlaveScheduleHasGrupo implements Serializable {
    private int schedule;
    private Grupo grupo;
}
