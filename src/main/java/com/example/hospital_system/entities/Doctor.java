package com.example.hospital_system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private int specialization_id;

    public Doctor() {
    }

    public Doctor(int doctorId, String doctorName, String phoneNumber, String address, Date dateOfBirth, int specialization_id) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.specialization_id = specialization_id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", specialization_id=" + specialization_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId && specialization_id == doctor.specialization_id && Objects.equals(doctorName, doctor.doctorName) && Objects.equals(phoneNumber, doctor.phoneNumber) && Objects.equals(address, doctor.address) && Objects.equals(dateOfBirth, doctor.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, doctorName, phoneNumber, address, dateOfBirth, specialization_id);
    }
}
