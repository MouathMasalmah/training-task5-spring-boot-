package com.example.hospital_system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Medicine {
    @Id
    private int medication_id;
    private String medication_name;
    private int remaining_quantity;
    private String description;

    public Medicine() {
    }

    public Medicine(int medication_id, String medication_name, int remaining_quantity, String description) {
        this.medication_id = medication_id;
        this.medication_name = medication_name;
        this.remaining_quantity = remaining_quantity;
        this.description = description;
    }

    public int getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(int medication_id) {
        this.medication_id = medication_id;
    }

    public String getMedication_name() {
        return medication_name;
    }

    public void setMedication_name(String medication_name) {
        this.medication_name = medication_name;
    }

    public int getRemaining_quantity() {
        return remaining_quantity;
    }

    public void setRemaining_quantity(int remaining_quantity) {
        this.remaining_quantity = remaining_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medication_id=" + medication_id +
                ", medication_name='" + medication_name + '\'' +
                ", remaining_quantity=" + remaining_quantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return medication_id == medicine.medication_id && remaining_quantity == medicine.remaining_quantity && Objects.equals(medication_name, medicine.medication_name) && Objects.equals(description, medicine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_id, medication_name, remaining_quantity, description);
    }
}
