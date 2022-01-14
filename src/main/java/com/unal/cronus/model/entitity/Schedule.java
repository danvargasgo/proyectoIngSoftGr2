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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedule_has_group",
            joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "idSchedule"),
            inverseJoinColumns = {@JoinColumn(name = "grupo_number", referencedColumnName = "number"),
                    @JoinColumn(name = "subject_code", referencedColumnName = "subject_code")}
    )
    private List<Grupo> grupos;

    public Schedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }
}
