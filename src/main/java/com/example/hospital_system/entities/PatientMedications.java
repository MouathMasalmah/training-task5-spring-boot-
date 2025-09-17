package com.example.hospital_system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class PatientMedications {
    @Id
    private int medication_id;
    @Id
    private int patient_id;
    private String dosage;
    private Date start_date;
    private Date end_date;

    public PatientMedications() {
    }

    public PatientMedications(int medication_id, int patient_id, String dosage, Date start_date, Date end_date) {
        this.medication_id = medication_id;
        this.patient_id = patient_id;
        this.dosage = dosage;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(int medication_id) {
        this.medication_id = medication_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "PatientMedications{" +
                "medication_id=" + medication_id +
                ", patient_id=" + patient_id +
                ", dosage='" + dosage + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PatientMedications that = (PatientMedications) o;
        return medication_id == that.medication_id && patient_id == that.patient_id && Objects.equals(dosage, that.dosage) && Objects.equals(start_date, that.start_date) && Objects.equals(end_date, that.end_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_id, patient_id, dosage, start_date, end_date);
    }
}
