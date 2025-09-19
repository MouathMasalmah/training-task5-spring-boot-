package com.example.hospital_system.services;

import com.example.hospital_system.dto.DoctorWithPatientsDto;
import com.example.hospital_system.entities.Doctor;
import com.example.hospital_system.entities.Patient;
import com.example.hospital_system.repositories.DoctorRepository;
import com.example.hospital_system.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No doctors found");
        }
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Doctor not found with id: " + id
                ));
    }

    public List<Doctor> getDoctorsBySpecialisation(int specializationId) {
        List<Doctor> doctors = doctorRepository.findBySpecializationId(specializationId);
        if (doctors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "No doctors found for specialization " + specializationId);
        }
        return doctors;
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(int id, Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Doctor not found with id: " + id
                ));

        if (doctorDetails.getName() != null) doctor.setName(doctorDetails.getName());
        if (doctorDetails.getPhoneNumber() != null) doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
        if (doctorDetails.getAddress() != null) doctor.setAddress(doctorDetails.getAddress());
        if (doctorDetails.getDateOfBirth() != null) doctor.setDateOfBirth(doctorDetails.getDateOfBirth());
        if (doctorDetails.getSpecializationId() > 0) doctor.setSpecializationId(doctorDetails.getSpecializationId());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }

    public DoctorWithPatientsDto getDoctorWithPatients(int id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Doctor not found with id: " + id
                ));

        List<Patient> patients = patientRepository.findByDoctorId(id);

        return new DoctorWithPatientsDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getPhoneNumber(),
                doctor.getAddress(),
                doctor.getDateOfBirth(),
                doctor.getSpecializationId(),
                patients
        );
    }
}
