package com.example.assessmentservice.service;

import com.example.assessmentservice.entity.Assessment;
import java.util.List;

public interface AssessmentService {
    Assessment createAssessment(Assessment assessment);
    List<Assessment> getAllAssessments();
    Assessment getAssessmentById(Long id);
    Assessment updateAssessment(Long id, Assessment assessment);
    void deleteAssessment(Long id);
    Assessment gradeAssessment(Long id, int marks);
}
