package com.example.medicalrecord_service.service;


import com.example.medicalrecord_service.model.MedicalRecord;
import com.example.medicalrecord_service.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;

   
    public MedicalRecord addRecord(MedicalRecord record) {
        return repository.save(record);
    }

    
    public MedicalRecord getRecordById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    
    public List<MedicalRecord> getRecordsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

   
    public List<MedicalRecord> getRecordsByDoctor(Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }

   
    public List<MedicalRecord> getAllRecords() {
        return repository.findAll();
    }

    
    public void deleteRecord(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Record not found");
        }
        repository.deleteById(id);
    }
}

