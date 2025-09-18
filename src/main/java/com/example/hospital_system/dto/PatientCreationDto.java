package com.example.hospital_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientCreationDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Date dateOfBirth;
    private int doctorId;
}