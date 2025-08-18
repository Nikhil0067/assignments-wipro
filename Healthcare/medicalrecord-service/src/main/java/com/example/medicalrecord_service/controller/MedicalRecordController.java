package com.example.medicalrecord_service.controller;


import com.example.medicalrecord_service.model.MedicalRecord;
import com.example.medicalrecord_service.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    
    @PostMapping
    public ResponseEntity<MedicalRecord> addRecord(@RequestBody MedicalRecord record) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addRecord(record));
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecordById(id));
    }

    
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(service.getRecordsByPatient(patientId));
    }

    
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(service.getRecordsByDoctor(doctorId));
    }

    
    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllRecords() {
        return ResponseEntity.ok(service.getAllRecords());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.ok("Medical record deleted successfully");
    }
}

