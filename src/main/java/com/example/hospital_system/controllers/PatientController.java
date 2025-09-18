package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.dto.PatientCreationDto;
import com.example.hospital_system.services.PatientService;
import com.example.hospital_system.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(value = "/api/patients",produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = {"", "/"})
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Patient> getPatientsByDoctor(@PathVariable int doctorId) {
        return patientService.getPatientsByDoctor(doctorId);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientCreationDto patientDto) {
        Optional<Doctor> doctorOpt = doctorService.getDoctorById(patientDto.getDoctorId());
        if (doctorOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setDoctor(doctorOpt.get());
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }
}