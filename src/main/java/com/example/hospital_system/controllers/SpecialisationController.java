package com.example.hospital_system.controllers;

import com.example.hospital_system.entities.Specialisation;
import com.example.hospital_system.services.SpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/specialisations",produces = MediaType.APPLICATION_JSON_VALUE)
public class SpecialisationController {
    @Autowired
    private SpecialisationService service;

    @GetMapping(value = {"", "/"})
    public List<Specialisation> getAllSpecialisations() {
        return service.getAllSpecialisations();
    }

    @GetMapping("/{id}")
    public Optional<Specialisation> getSpecialisationById(@PathVariable int id) {
        return service.getSpecialisationById(id);
    }

    @PostMapping
    public Specialisation createSpecialisation(@RequestBody Specialisation specialisation) {
        return service.createSpecialisation(specialisation);
    }

    @PutMapping("/{id}")
    public Specialisation updateSpecialisation(@PathVariable int id, @RequestBody Specialisation specialisation) {
        return service.updateSpecialisation(id, specialisation);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialisation(@PathVariable int id) {
        service.deleteSpecialisation(id);
    }
}
