package com.example.hospital_system.services;

import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsBySpecialisation(int specialization_id) {
        return doctorRepository.findBySpecializationId(specialization_id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(int id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setName(doctorDetails.getName());
        doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
        doctor.setAddress(doctorDetails.getAddress());
        doctor.setDateOfBirth(doctorDetails.getDateOfBirth());
        doctor.setSpecializationId(doctorDetails.getSpecializationId());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
