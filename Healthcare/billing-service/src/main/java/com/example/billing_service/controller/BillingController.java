package com.example.billing_service.controller;

import com.example.billing_service.dto.BillingResponse;
import com.example.billing_service.dto.InsuranceRequest;
import com.example.billing_service.dto.PaymentRequest;
import com.example.billing_service.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillingController {

    private final BillingService service;

    public BillingController(BillingService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBill(id));
    }

    @GetMapping
    public ResponseEntity<List<BillingResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/pay/{id}")
    public ResponseEntity<BillingResponse> pay(@PathVariable Long id, @RequestBody PaymentRequest req) {
        return ResponseEntity.ok(service.pay(id, req));
    }

    @PostMapping("/insurance/{id}")
    public ResponseEntity<BillingResponse> claimInsurance(@PathVariable Long id, @RequestBody InsuranceRequest req) {
        return ResponseEntity.ok(service.claimInsurance(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
