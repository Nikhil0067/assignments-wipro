package com.example.billing_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BillingResponse {
    private Long billId;
    private Long appointmentId;
    private Long patientId;
    private Long doctorId;
    private BigDecimal amount;
    private String currency;
    private String paymentStatus;
    private String insuranceStatus;
    private LocalDateTime createdAt;

    public BillingResponse() {}

    public BillingResponse(Long billId, Long appointmentId, Long patientId, Long doctorId,
                           BigDecimal amount, String currency, String paymentStatus,
                           String insuranceStatus, LocalDateTime createdAt) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.amount = amount;
        this.currency = currency;
        this.paymentStatus = paymentStatus;
        this.insuranceStatus = insuranceStatus;
        this.createdAt = createdAt;
    }

    // getters/setters
    public Long getBillId() { return billId; }
    public void setBillId(Long billId) { this.billId = billId; }
    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getInsuranceStatus() { return insuranceStatus; }
    public void setInsuranceStatus(String insuranceStatus) { this.insuranceStatus = insuranceStatus; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
