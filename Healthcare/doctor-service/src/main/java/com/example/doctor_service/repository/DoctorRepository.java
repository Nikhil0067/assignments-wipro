package com.example.doctor_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.doctor_service.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

