package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Medicine;
import com.example.hospital_system.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable int id) {
        return medicineService.getMedicineById(id);
    }

    @GetMapping("/search")
    public List<Medicine> searchMedicines(@RequestParam String name) {
        return medicineService.searchMedicinesByName(name);
    }

    @GetMapping("/low-stock")
    public List<Medicine> getLowStockMedicines(@RequestParam int quantity) {
        return medicineService.getLowStockMedicines(quantity);
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineService.createMedicine(medicine);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(@PathVariable int id, @RequestBody Medicine medicine) {
        return medicineService.updateMedicine(id, medicine);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable int id) {
        medicineService.deleteMedicine(id);
    }
}
