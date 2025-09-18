package com.example.hospital_system.entities;
import com.example.hospital_system.PatientMedicationsId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@IdClass(PatientMedicationsId.class)
public class PatientMedications {
    @Id
    private int medicationId;
    @Id
    private int patientId;
    private String dosage;
    private Date startDate;
    private Date endDate;

    public PatientMedications() {
    }

    public PatientMedications(int medicationId, int patientId, String dosage, Date startDate, Date endDate) {
        this.medicationId = medicationId;
        this.patientId = patientId;
        this.dosage = dosage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PatientMedications{" +
                "medication_id=" + medicationId +
                ", patient_id=" + patientId +
                ", dosage='" + dosage + '\'' +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PatientMedications that = (PatientMedications) o;
        return medicationId == that.medicationId && patientId == that.patientId && Objects.equals(dosage, that.dosage) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, patientId, dosage, startDate, endDate);
    }
}
