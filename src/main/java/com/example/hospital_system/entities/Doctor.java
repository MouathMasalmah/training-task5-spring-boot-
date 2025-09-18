package com.example.hospital_system.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private int id;

    @NotBlank(message = "Doctor name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    private String address;

    @NotNull(message = "Date of birth is required")
    private Date dateOfBirth;

    @Column(name = "specialization_id")
    private int specializationId;


    public Doctor() {
    }

    public Doctor(int id, String name, String phoneNumber, String address, Date dateOfBirth, int specializationId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.specializationId = specializationId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + id +
                ", doctorName='" + name + '\'' +
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
        return id == doctor.id && specializationId == doctor.specializationId && Objects.equals(name, doctor.name) && Objects.equals(phoneNumber, doctor.phoneNumber) && Objects.equals(address, doctor.address) && Objects.equals(dateOfBirth, doctor.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, address, dateOfBirth, specializationId);
    }
}
