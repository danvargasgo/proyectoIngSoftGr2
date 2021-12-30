package com.unal.cronus.model.entitity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "schedules")
public class Schedule implements Serializable {
    @Id
    private Integer idSchedule;

    public Schedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return idSchedule.equals(schedule.idSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSchedule);
    }
}
