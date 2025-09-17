package com.example.hospital_system.services;

import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientsByDoctor(int doctor_id) {
        return patientRepository.findByDoctorId(doctor_id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(int id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setPatientName(patientDetails.getPatientName());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());
        patient.setEmail(patientDetails.getEmail());
        patient.setAddress(patientDetails.getAddress());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setDoctorId(patientDetails.getDoctorId());

        return patientRepository.save(patient);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
}
