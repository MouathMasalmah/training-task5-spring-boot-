package com.example.hospital_system.repositories;

import com.example.hospital_system.entities.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Integer> {
}