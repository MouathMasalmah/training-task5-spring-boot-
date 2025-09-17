package com.example.hospital_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;
    private String patient_name;
    private String phone_number;
    private String email;
    private String address;
    private Date date_of_birth;
    private int doctor_id;

    public Patient() {
    }

    public Patient(int patient_id, String patient_name, String phone_number, String email, String address, Date date_of_birth, int doctor_id) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", doctor_id='" + doctor_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patient_id == patient.patient_id && Objects.equals(patient_name, patient.patient_name) && Objects.equals(phone_number, patient.phone_number) && Objects.equals(email, patient.email) && Objects.equals(address, patient.address) && Objects.equals(date_of_birth, patient.date_of_birth) && Objects.equals(doctor_id, patient.doctor_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient_id, patient_name, phone_number, email, address, date_of_birth, doctor_id);
    }
}
