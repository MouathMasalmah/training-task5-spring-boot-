package com.example.hospital_system.repositories;
import com.example.hospital_system.PatientMedicationsId;
import com.example.hospital_system.entities.PatientMedications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientMedicationsRepository extends JpaRepository<PatientMedications, PatientMedicationsId> {
    List<PatientMedications> findByPatientId(int patientId);
    List<PatientMedications> findByMedicationId(int medicationId);
}
