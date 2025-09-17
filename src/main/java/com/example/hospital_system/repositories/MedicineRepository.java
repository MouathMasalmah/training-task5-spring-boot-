package com.example.hospital_system.repositories;

import com.example.hospital_system.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    List<Medicine> findByMedicationNameContaining(String name);
    List<Medicine> findByRemainingQuantityLessThan(int quantity);
}