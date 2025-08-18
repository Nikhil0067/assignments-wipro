package com.example.medicalrecord_service.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;      
    private Long doctorId;       

    private String diagnosis;
    private String prescription;
    private String testResults;

    private LocalDateTime visitDate = LocalDateTime.now();

    public MedicalRecord() {}

    public MedicalRecord(Long patientId, Long doctorId, String diagnosis, String prescription, String testResults) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.testResults = testResults;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public String getTestResults() { return testResults; }
    public void setTestResults(String testResults) { this.testResults = testResults; }

    public LocalDateTime getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDateTime visitDate) { this.visitDate = visitDate; }
}

