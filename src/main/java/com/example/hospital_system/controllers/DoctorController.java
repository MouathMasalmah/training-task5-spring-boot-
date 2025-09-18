package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No doctors found");
        } else {
            return ResponseEntity.ok(doctors);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable int id) {
        Optional<Doctor> doctorOpt = doctorService.getDoctorById(id);
        if (doctorOpt.isPresent()) {
            return ResponseEntity.ok(doctorOpt.get()); // ResponseEntity<Doctor>
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id " + id + " not found"); // ResponseEntity<String>
        }
    }


    @GetMapping("/specialisation/{specialisationId}")
    public List<Doctor> getDoctorsBySpecialisation(@PathVariable int specialisationId) {
        return doctorService.getDoctorsBySpecialisation(specialisationId);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }
}
