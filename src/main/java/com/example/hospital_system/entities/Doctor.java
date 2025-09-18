package com.example.hospital_system.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    @Column(name = "specialization_id")
    private int specializationId;


    public Doctor() {
    }

    public Doctor(int doctorId, String doctorName, String phoneNumber, String address, Date dateOfBirth, int specializationId) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", specialization_id=" + specializationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId && specializationId == doctor.specializationId && Objects.equals(doctorName, doctor.doctorName) && Objects.equals(phoneNumber, doctor.phoneNumber) && Objects.equals(address, doctor.address) && Objects.equals(dateOfBirth, doctor.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, doctorName, phoneNumber, address, dateOfBirth, specializationId);
    }
}
