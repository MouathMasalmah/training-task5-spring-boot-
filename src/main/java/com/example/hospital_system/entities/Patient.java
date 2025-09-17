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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patient_id) {
        this.patientId = patient_id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patient_name) {
        this.patientName = patient_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.dateOfBirth = date_of_birth;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctor_id) {
        this.doctorId = doctor_id;
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
