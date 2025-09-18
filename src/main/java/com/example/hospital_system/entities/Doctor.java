package com.example.hospital_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^(059|056|057)\\d{7}$",
            message = "Phone number must start with 059, 056, or 057 and be 10 digits long"
    )
    private String phoneNumber;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotNull
    @Past
    private Date dateOfBirth;

    @Min(1)
    @Column(name = "specialization_id")
    private int specializationId;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Patient> patients;

    public Doctor() {}

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
        return id == doctor.id &&
                specializationId == doctor.specializationId &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(phoneNumber, doctor.phoneNumber) &&
                Objects.equals(address, doctor.address) &&
                Objects.equals(dateOfBirth, doctor.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, address, dateOfBirth, specializationId);
    }
}
