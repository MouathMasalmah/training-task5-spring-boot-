package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping({"", "/"})
    public ResponseEntity<?> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No doctors found");
        }
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctorById(@PathVariable int id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get()); // Doctor object
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id " + id + " not found"); // String message
        }
    }

    @GetMapping("/specialisation/{specialisationId}")
    public ResponseEntity<?> getDoctorsBySpecialisation(@PathVariable int specialisationId) {
        List<Doctor> doctors = doctorService.getDoctorsBySpecialisation(specialisationId);
        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doctors found for specialization " + specialisationId);
        }
        return ResponseEntity.ok(doctors);
    }

    @PostMapping
    public ResponseEntity<?> createDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable int id, @Valid @RequestBody Doctor doctorDetails) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDetails);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor with id " + id + " deleted successfully");
    }
}
