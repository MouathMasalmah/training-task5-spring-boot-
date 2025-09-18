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
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specializationId;
    private String specializationName;

    public Specialisation() {
    }

    public Specialisation(int specializationId, String specializationName) {
        this.specializationId = specializationId;
        this.specializationName = specializationName;
    }

    @Override
    public String toString() {
        return "Specialisation{" +
                "specialization_id=" + specializationId +
                ", specialization_name='" + specializationName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Specialisation that = (Specialisation) o;
        return specializationId == that.specializationId && Objects.equals(specializationName, that.specializationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specializationId, specializationName);
    }
}
