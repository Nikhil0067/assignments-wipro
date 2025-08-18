package com.example.billing_service.dto;

import java.math.BigDecimal;

public class PaymentRequest {
    private BigDecimal amount;
    private String mode; // e.g., UPI, CARD, CASH

    public PaymentRequest() {}

    public PaymentRequest(BigDecimal amount, String mode) {
        this.amount = amount;
        this.mode = mode;
    }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
}
