package com.example.hospital_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String patientName;
    private String phoneNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    private int doctorId;

    public Patient() {
    }

    public Patient(int patientId, String patientName, String phoneNumber, String email, String address, Date dateOfBirth, int doctorId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patientId +
                ", patient_name='" + patientName + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", doctor_id='" + doctorId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId && Objects.equals(patientName, patient.patientName) && Objects.equals(phoneNumber, patient.phoneNumber) && Objects.equals(email, patient.email) && Objects.equals(address, patient.address) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(doctorId, patient.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, patientName, phoneNumber, email, address, dateOfBirth, doctorId);
    }
}
