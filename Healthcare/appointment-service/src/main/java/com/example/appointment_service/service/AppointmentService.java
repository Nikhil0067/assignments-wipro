package com.example.appointment_service.service;


import com.example.appointment_service.dto.AppointmentRequest;
import com.example.appointment_service.dto.AppointmentResponse;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final KafkaProducerService kafkaProducerService;

    public AppointmentService(AppointmentRepository appointmentRepository, KafkaProducerService kafkaProducerService) {
        this.appointmentRepository = appointmentRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    
    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        Appointment appointment = new Appointment(
                request.getPatientId(),
                request.getDoctorId(),
                request.getAppointmentDate(),
                "CONFIRMED"
        );

        Appointment saved = appointmentRepository.save(appointment);

     
        String message = "Appointment " + saved.getId() + " confirmed for patient " +
                saved.getPatientId() + " with doctor " + saved.getDoctorId();
        kafkaProducerService.sendAppointmentConfirmedMessage(message);

        return mapToResponse(saved);
    }

    
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    
    public AppointmentResponse updateAppointment(Long id, AppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setStatus("UPDATED");

        Appointment updated = appointmentRepository.save(appointment);

 
        String message = "Appointment " + updated.getId() + " updated for patient " +
                updated.getPatientId() + " with doctor " + updated.getDoctorId();
        kafkaProducerService.sendAppointmentConfirmedMessage(message);

        return mapToResponse(updated);
    }

   
    public void deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointmentRepository.delete(appointment);

 
        String message = "Appointment " + id + " has been cancelled.";
        kafkaProducerService.sendAppointmentConfirmedMessage(message);
    }

   
    private AppointmentResponse mapToResponse(Appointment appointment) {
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getStatus()
        );
    }
}