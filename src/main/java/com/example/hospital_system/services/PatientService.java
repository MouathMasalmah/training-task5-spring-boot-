package com.example.hospital_system.services;

import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorService doctorService;

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No patients found");
        }
        return patients;
    }

    public Patient getPatientById(int id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Patient not found with id: " + id
                ));
    }

    public List<Patient> getPatientsByDoctor(int doctorId) {
        List<Patient> patients = patientRepository.findByDoctorId(doctorId);
        if (patients.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "No patients found for doctor id: " + doctorId);
        }
        return patients;
    }

    public Patient createPatient(Patient patient, int doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        patient.setDoctor(doctor);
        return patientRepository.save(patient);
    }

    public Patient updatePatient(int id, Patient patientDetails) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Patient not found with id: " + id
                ));

        if (patientDetails.getName() != null) patient.setName(patientDetails.getName());
        if (patientDetails.getPhoneNumber() != null) patient.setPhoneNumber(patientDetails.getPhoneNumber());
        if (patientDetails.getEmail() != null) patient.setEmail(patientDetails.getEmail());
        if (patientDetails.getAddress() != null) patient.setAddress(patientDetails.getAddress());
        if (patientDetails.getDateOfBirth() != null) patient.setDateOfBirth(patientDetails.getDateOfBirth());
        if (patientDetails.getDoctor() != null) patient.setDoctor(patientDetails.getDoctor());

        return patientRepository.save(patient);
    }

    public void deletePatient(int id) {
        if (!patientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    public Doctor updatePatientDoctor(int patientId, int newDoctorId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Patient not found with id: " + patientId
                ));

        Doctor newDoctor = doctorService.getDoctorById(newDoctorId);

        patient.setDoctor(newDoctor);
        patientRepository.save(patient);
        return newDoctor;
    }
}
