package com.example.hospital_system.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialization_id;
    private String specialization_name;

    public Specialisation() {
    }

    public Specialisation(int specialization_id, String specialization_name) {
        this.specialization_id = specialization_id;
        this.specialization_name = specialization_name;
    }

    public int getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        this.specialization_id = specialization_id;
    }

    public String getSpecialization_name() {
        return specialization_name;
    }

    public void setSpecialization_name(String specialization_name) {
        this.specialization_name = specialization_name;
    }

    @Override
    public String toString() {
        return "Specialisation{" +
                "specialization_id=" + specialization_id +
                ", specialization_name='" + specialization_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Specialisation that = (Specialisation) o;
        return specialization_id == that.specialization_id && Objects.equals(specialization_name, that.specialization_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization_id, specialization_name);
    }
}
