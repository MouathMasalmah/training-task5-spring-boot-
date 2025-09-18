package com.example.hospital_system.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private int id;

    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Date dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference
    private Doctor doctor;

    public Patient() {}

    public Patient(int id, String name, String phoneNumber, String email,
                   String address, Date dateOfBirth, Doctor doctor) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + id +
                ", patient_name='" + name + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth=" + dateOfBirth +
                ", doctor_id=" + (doctor != null ? doctor.getId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(name, patient.name) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(dateOfBirth, patient.dateOfBirth) &&
                Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, address, dateOfBirth, doctor);
    }
}
