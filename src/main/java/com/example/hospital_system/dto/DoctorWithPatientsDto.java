package com.example.hospital_system.dto;

import com.example.hospital_system.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorWithPatientsDto {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private int specializationId;
    private List<Patient> patients;
}