package com.example.hospital_system.services;

import com.example.hospital_system.entities.Specialisation;
import com.example.hospital_system.repositories.SpecialisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialisationService {
    @Autowired
    private SpecialisationRepository specialisationRepository;

    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAll();
    }

    public Optional<Specialisation> getSpecialisationById(int id) {
        return specialisationRepository.findById(id);
    }

    public Specialisation createSpecialisation(Specialisation specialisation) {
        return specialisationRepository.save(specialisation);
    }

    public Specialisation updateSpecialisation(int id, Specialisation specialisationDetails) {
        Specialisation specialisation = specialisationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialisation not found"));

        specialisation.setSpecializationName(specialisationDetails.getSpecializationName());
        return specialisationRepository.save(specialisation);
    }

    public void deleteSpecialisation(int id) {
        specialisationRepository.deleteById(id);
    }
}
