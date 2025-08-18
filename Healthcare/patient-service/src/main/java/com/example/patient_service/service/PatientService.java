package com.example.patient_service.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.patient_service.repository.PatientRepository;
import com.example.patient_service.model.Patient;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(patient -> {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setContactNumber(patientDetails.getContactNumber());
            patient.setInsuranceNumber(patientDetails.getInsuranceNumber());
            return patientRepository.save(patient);
        }).orElse(null);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}

