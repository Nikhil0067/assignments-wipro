package com.example.billing_service.kafka;

import com.example.billing_service.dto.BillingResponse;
import com.example.billing_service.service.BillingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentEventConsumer {

    private final BillingService billingService;

    public AppointmentEventConsumer(BillingService billingService) {
        this.billingService = billingService;
    }

    @KafkaListener(topics = "appointment-confirmed", groupId = "billing-group")
    public void onAppointmentConfirmed(String message) {
        System.out.println("📥 Billing Service received Kafka message: " + message);
        BillingResponse created = billingService.generateBillFromAppointmentMessage(message);
        System.out.println("🧾 Bill generated with ID: " + created.getBillId());
    }
}
