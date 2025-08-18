package com.example.vehicle_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(unique = true, nullable = false)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public enum VehicleType {
        BUS, CAR, VAN, TRUCK
    }

    public enum VehicleStatus {
        AVAILABLE, ON_TRIP, MAINTENANCE
    }
}