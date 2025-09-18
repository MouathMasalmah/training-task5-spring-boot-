package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/patients",produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {
    @Autowired
    private PatientService patientService;

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
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
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
