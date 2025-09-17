package com.example.hospital_system.services;

import com.example.hospital_system.entities.Medicine;
import com.example.hospital_system.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(int id) {
        return medicineRepository.findById(id);
    }

    public List<Medicine> searchMedicinesByName(String name) {
        return medicineRepository.findByMedicationNameContaining(name);
    }

    public List<Medicine> getLowStockMedicines(int quantity) {
        return medicineRepository.findByRemainingQuantityLessThan(quantity);
    }

    public Medicine createMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(int id, Medicine medicineDetails) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        medicine.setMedication_name(medicineDetails.getMedication_name());
        medicine.setRemaining_quantity(medicineDetails.getRemaining_quantity());
        medicine.setDescription(medicineDetails.getDescription());

        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(int id) {
        medicineRepository.deleteById(id);
    }
}
