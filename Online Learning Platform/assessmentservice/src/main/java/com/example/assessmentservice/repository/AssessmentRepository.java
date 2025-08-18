package com.example.assessmentservice.repository;

import com.example.assessmentservice.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {}
