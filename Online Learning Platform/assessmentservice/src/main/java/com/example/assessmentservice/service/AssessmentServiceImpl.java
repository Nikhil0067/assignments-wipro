package com.example.assessmentservice.service;

import com.example.assessmentservice.entity.Assessment;
import com.example.assessmentservice.exception.ResourceNotFoundException;
import com.example.assessmentservice.repository.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentRepository;

    public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    @Override
    public Assessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found with id " + id));
    }

    @Override
    public Assessment updateAssessment(Long id, Assessment assessment) {
        Assessment existing = getAssessmentById(id);
        existing.setTitle(assessment.getTitle());
        existing.setDescription(assessment.getDescription());
        existing.setMaxMarks(assessment.getMaxMarks());
        return assessmentRepository.save(existing);
    }

    @Override
    public void deleteAssessment(Long id) {
        assessmentRepository.deleteById(id);
    }
    

    @Override
    public Assessment gradeAssessment(Long id, int marks) {
        Assessment assessment = getAssessmentById(id);
        assessment.setObtainedMarks(marks);
        assessment.setSubmitted(true);
        return assessmentRepository.save(assessment);
    }
}
