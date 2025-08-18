package com.example.billing_service.service;

import com.example.billing_service.dto.BillingResponse;
import com.example.billing_service.dto.InsuranceRequest;
import com.example.billing_service.dto.PaymentRequest;
import com.example.billing_service.model.Billing;
import com.example.billing_service.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BillingService {

    private final BillingRepository repository;

    public BillingService(BillingRepository repository) {
        this.repository = repository;
    }

    // Called by Kafka consumer when an appointment is confirmed
    public BillingResponse generateBillFromAppointmentMessage(String message) {
        // Expecting something like:
        // "Appointment 12 confirmed for patient 5 with doctor 9"
        Long appointmentId = null, patientId = null, doctorId = null;

        Pattern p = Pattern.compile("Appointment\\s+(\\d+)\\s+confirmed\\s+for\\s+patient\\s+(\\d+)\\s+with\\s+doctor\\s+(\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(message);
        if (m.find()) {
            appointmentId = Long.valueOf(m.group(1));
            patientId = Long.valueOf(m.group(2));
            doctorId = Long.valueOf(m.group(3));
        } else {
            // If the message format changes, at least don't crash
            throw new RuntimeException("Cannot parse appointment confirmation message: " + message);
        }

        Billing bill = new Billing();
        bill.setAppointmentId(appointmentId);
        bill.setPatientId(patientId);
        bill.setDoctorId(doctorId);

        // Simple demo fee. In real-world, look up fee from Doctor Service/specialization.
        bill.setAmount(new BigDecimal("500.00"));
        bill.setCurrency("INR");
        bill.setPaymentStatus("PENDING");
        bill.setInsuranceStatus("PENDING");

        Billing saved = repository.save(bill);
        return map(saved);
    }

    public BillingResponse getBill(Long id) {
        Billing b = repository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));
        return map(b);
    }

    public List<BillingResponse> getAll() {
        return repository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public BillingResponse pay(Long id, PaymentRequest req) {
        Billing b = repository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));

        // Minimal validation: amount must match or exceed billed amount (demo logic)
        if (req.getAmount() == null || b.getAmount() == null || req.getAmount().compareTo(b.getAmount()) < 0) {
            throw new RuntimeException("Insufficient payment amount");
        }

        b.setPaymentStatus("PAID");
        Billing saved = repository.save(b);
        return map(saved);
    }

    public BillingResponse claimInsurance(Long id, InsuranceRequest req) {
        Billing b = repository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));

        // Demo: instantly approve if provider provided
        if (req.getProvider() == null || req.getProvider().isBlank()) {
            b.setInsuranceStatus("REJECTED");
        } else {
            b.setInsuranceStatus("APPROVED");
        }
        Billing saved = repository.save(b);
        return map(saved);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BillingResponse map(Billing b) {
        return new BillingResponse(
                b.getId(),
                b.getAppointmentId(),
                b.getPatientId(),
                b.getDoctorId(),
                b.getAmount(),
                b.getCurrency(),
                b.getPaymentStatus(),
                b.getInsuranceStatus(),
                b.getCreatedAt()
        );
    }
}
