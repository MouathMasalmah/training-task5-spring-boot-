package com.example.hospital_system;

import java.io.Serializable;
import java.util.Objects;

public class PatientMedicationsId implements Serializable {
    private int medicationId;
    private int patientId;

    public PatientMedicationsId() {}

    public PatientMedicationsId(int medicationId, int patientId) {
        this.medicationId = medicationId;
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientMedicationsId)) return false;
        PatientMedicationsId that = (PatientMedicationsId) o;
        return medicationId == that.medicationId && patientId == that.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, patientId);
    }
}
