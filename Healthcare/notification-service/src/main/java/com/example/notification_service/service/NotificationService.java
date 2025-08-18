package com.example.notification_service.service;



import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String appointmentDetails) {
        
        System.out.println("Notification sent: " + appointmentDetails);
    }
}

