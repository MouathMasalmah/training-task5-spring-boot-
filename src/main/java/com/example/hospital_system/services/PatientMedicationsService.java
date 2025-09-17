package com.example.hospital_system.services;

import com.example.hospital_system.entities.PatientMedications;
import com.example.hospital_system.PatientMedicationsId;
import com.example.hospital_system.repositories.PatientMedicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientMedicationsService {
    @Autowired
    private PatientMedicationsRepository repository;

    public List<PatientMedications> getAllPatientMedications() {
        return repository.findAll();
    }

    public Optional<PatientMedications> getPatientMedicationById(PatientMedicationsId id) {
        return repository.findById(id);
    }

    public List<PatientMedications> getByPatientId(int patientId) {
        return repository.findByPatientId(patientId);
    }

    public List<PatientMedications> getByMedicationId(int medicationId) {
        return repository.findByMedicationId(medicationId);
    }

    public PatientMedications createPatientMedication(PatientMedications pm) {
        return repository.save(pm);
    }

    public PatientMedications updatePatientMedication(PatientMedicationsId id, PatientMedications pmDetails) {
        PatientMedications pm = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        pm.setDosage(pmDetails.getDosage());
        pm.setStartDate(pmDetails.getStartDate());
        pm.setEndDate(pmDetails.getEndDate());

        return repository.save(pm);
    }

    public void deletePatientMedication(PatientMedicationsId id) {
        repository.deleteById(id);
    }
}
