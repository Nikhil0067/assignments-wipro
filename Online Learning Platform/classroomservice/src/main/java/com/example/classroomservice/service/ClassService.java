package com.example.classroomservice.service;



import com.example.classroomservice.dto.ClassDTO;
import com.example.classroomservice.entity.ClassSession;
import com.example.classroomservice.exception.ResourceNotFoundException;
import com.example.classroomservice.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository classRepository;

    public ClassSession createClass(ClassDTO classDTO) {
        ClassSession session = ClassSession.builder()
                .title(classDTO.getTitle())
                .description(classDTO.getDescription())
                .startTime(classDTO.getStartTime())
                .endTime(classDTO.getEndTime())
                .build();
        return classRepository.save(session);
    }

    public List<ClassSession> getAllClasses() {
        return classRepository.findAll();
    }

    public ClassSession getClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + id));
    }
}
