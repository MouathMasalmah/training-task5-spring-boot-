package com.example.hospital_system.services;

import com.example.hospital_system.entities.Doctor;
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

    @Autowired
    private DoctorService doctorService;

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

        patient.setName(patientDetails.getName());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());
        patient.setEmail(patientDetails.getEmail());
        patient.setAddress(patientDetails.getAddress());
        patient.setDateOfBirth(patientDetails.getDateOfBirth());
        patient.setDoctor(patientDetails.getDoctor());

        return patientRepository.save(patient);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }
    public Doctor updatePatientDoctor(int patientId, int newDoctorId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient with id " + patientId + " not found."));

        Doctor newDoctor = doctorService.getDoctorById(newDoctorId)
                .orElseThrow(() -> new RuntimeException("Doctor with id " + newDoctorId + " not found."));

        patient.setDoctor(newDoctor);
        patientRepository.save(patient);
        return newDoctor;
    }
}
