package com.example.hospital_system;

import java.io.Serializable;
import java.util.Objects;

public class PatientMedicationsId implements Serializable {
    private int medication_id;
    private int patient_id;

    public PatientMedicationsId() {}

    public PatientMedicationsId(int medication_id, int patient_id) {
        this.medication_id = medication_id;
        this.patient_id = patient_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientMedicationsId)) return false;
        PatientMedicationsId that = (PatientMedicationsId) o;
        return medication_id == that.medication_id && patient_id == that.patient_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_id, patient_id);
    }
}
