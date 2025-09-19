package com.example.hospital_system.controllers;

import com.example.hospital_system.dto.DoctorWithPatientsDto;
import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping("/specialisation/{specialisationId}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialisation(@PathVariable int specialisationId) {
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialisation(specialisationId));
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.createDoctor(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @Valid @RequestBody Doctor doctorDetails) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor with id " + id + " deleted successfully");
    }

    @GetMapping("/{id}/patients")
    public ResponseEntity<DoctorWithPatientsDto> getDoctorWithPatients(@PathVariable int id) {
        return ResponseEntity.ok(doctorService.getDoctorWithPatients(id));
    }
}
