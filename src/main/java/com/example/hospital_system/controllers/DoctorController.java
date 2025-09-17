package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id);
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
