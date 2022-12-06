package ru.zalimannard.bachelorthesisserver.appointment.status.type;

import java.util.Objects;

public record AppointmentStatusType(int id, String name) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentStatusType appointmentStatusType = (AppointmentStatusType) o;
        return id == appointmentStatusType.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}