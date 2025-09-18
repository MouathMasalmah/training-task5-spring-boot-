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
    private int id;
    private String name;
    private int remainingQuantity;
    private String description;

    public Medicine() {
    }

    public Medicine(int id, String name, int remainingQuantity, String description) {
        this.id = id;
        this.name = name;
        this.remainingQuantity = remainingQuantity;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medication_id=" + id +
                ", medication_name='" + name + '\'' +
                ", remaining_quantity=" + remainingQuantity +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id && remainingQuantity == medicine.remainingQuantity && Objects.equals(name, medicine.name) && Objects.equals(description, medicine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, remainingQuantity, description);
    }
}
