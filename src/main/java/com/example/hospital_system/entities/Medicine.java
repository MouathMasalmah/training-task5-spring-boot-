package com.example.hospital_system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicationId;
    private String medicationName;
    private int remainingQuantity;
    private String description;

    public Medicine() {
    }

    public Medicine(int medicationId, String medicationName, int remainingQuantity, String description) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.remainingQuantity = remainingQuantity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medication_id=" + medicationId +
                ", medication_name='" + medicationName + '\'' +
                ", remaining_quantity=" + remainingQuantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return medicationId == medicine.medicationId && remainingQuantity == medicine.remainingQuantity && Objects.equals(medicationName, medicine.medicationName) && Objects.equals(description, medicine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, medicationName, remainingQuantity, description);
    }
}
