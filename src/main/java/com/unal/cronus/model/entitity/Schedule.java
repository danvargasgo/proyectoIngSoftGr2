package com.unal.cronus.model.entitity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSchedule;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private List<ScheduleHasGrupo> scheduleHasGrupo;

    public Schedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }
}
