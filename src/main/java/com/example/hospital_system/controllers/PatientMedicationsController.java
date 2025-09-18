package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.PatientMedications;
import com.example.hospital_system.PatientMedicationsId;
import com.example.hospital_system.services.PatientMedicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/patient/medications", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientMedicationsController {
    @Autowired
    private PatientMedicationsService service;

    @GetMapping(value = {"", "/"})
    public List<PatientMedications> getAllPatientMedications() {
        return service.getAllPatientMedications();
    }

    @GetMapping("/patient/{patientId}")
    public List<PatientMedications> getByPatientId(@PathVariable int patientId) {
        return service.getByPatientId(patientId);
    }

    @GetMapping("/medicine/{medicineId}")
    public List<PatientMedications> getByMedicationId(@PathVariable int medicineId) {
        return service.getByMedicationId(medicineId);
    }

    @GetMapping("/{patientId}/{medicineId}")
    public Optional<PatientMedications> getById(@PathVariable int patientId, @PathVariable int medicineId) {
        PatientMedicationsId id = new PatientMedicationsId(medicineId, patientId);
        return service.getPatientMedicationById(id);
    }

    @PostMapping
    public PatientMedications create(@RequestBody PatientMedications pm) {
        return service.createPatientMedication(pm);
    }

    @PutMapping("/{patientId}/{medicineId}")
    public PatientMedications update(@PathVariable int patientId,
                                     @PathVariable int medicineId,
                                     @RequestBody PatientMedications pm) {
        PatientMedicationsId id = new PatientMedicationsId(medicineId, patientId);
        return service.updatePatientMedication(id, pm);
    }

    @DeleteMapping("/{patientId}/{medicineId}")
    public void delete(@PathVariable int patientId, @PathVariable int medicineId) {
        PatientMedicationsId id = new PatientMedicationsId(medicineId, patientId);
        service.deletePatientMedication(id);
    }
}
