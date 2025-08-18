package com.example.notification_service.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.example.notification_service.service.NotificationService;

@Component
public class AppointmentConsumer {

    private final NotificationService notificationService;

    public AppointmentConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "appointments-topic", groupId = "notification-group")
    public void consume(String message) {
        System.out.println("📩 Received from Kafka: " + message);
        notificationService.sendNotification(message);
    }
}
