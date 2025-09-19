package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.dto.PatientCreationDto;
import com.example.hospital_system.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(value = "/api/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = {"", "/"})
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Patient> getPatientsByDoctor(@PathVariable int doctorId) {
        return patientService.getPatientsByDoctor(doctorId);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientCreationDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setPhoneNumber(patientDto.getPhoneNumber());
        patient.setEmail(patientDto.getEmail());
        patient.setAddress(patientDto.getAddress());
        patient.setDateOfBirth(patientDto.getDateOfBirth());

        Patient createdPatient = patientService.createPatient(patient, patientDto.getDoctorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with id " + id + " deleted successfully");
    }

    @PutMapping("/{patientId}/doctor/{newDoctorId}")
    public ResponseEntity<String> updatePatientDoctor(@PathVariable int patientId, @PathVariable int newDoctorId) {
        Doctor updatedDoctor = patientService.updatePatientDoctor(patientId, newDoctorId);
        return ResponseEntity.ok("Doctor updated successfully. New doctor info: \n" + updatedDoctor.toString());
    }
}
