package com.example.hospital_system.services;

import com.example.hospital_system.entities.PatientMedications;
import com.example.hospital_system.entities.PatientMedicationsId;
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

    public List<PatientMedications> getByPatientId(int patient_id) {
        return repository.findByPatient_id(patient_id);
    }

    public List<PatientMedications> getByMedicationId(int medication_id) {
        return repository.findByMedication_id(medication_id);
    }

    public PatientMedications createPatientMedication(PatientMedications pm) {
        return repository.save(pm);
    }

    public PatientMedications updatePatientMedication(PatientMedicationsId id, PatientMedications pmDetails) {
        PatientMedications pm = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        pm.setDosage(pmDetails.getDosage());
        pm.setStart_date(pmDetails.getStart_date());
        pm.setEnd_date(pmDetails.getEnd_date());

        return repository.save(pm);
    }

    public void deletePatientMedication(PatientMedicationsId id) {
        repository.deleteById(id);
    }
}
