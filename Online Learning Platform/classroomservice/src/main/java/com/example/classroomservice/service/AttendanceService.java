package com.example.classroomservice.service;



import com.example.classroomservice.dto.AttendanceDTO;
import com.example.classroomservice.entity.Attendance;
import com.example.classroomservice.entity.ClassSession;
import com.example.classroomservice.exception.ResourceNotFoundException;
import com.example.classroomservice.repository.AttendanceRepository;
import com.example.classroomservice.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final ClassRepository classRepository;

    public Attendance markAttendance(Long classId, AttendanceDTO dto) {
        ClassSession session = classRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + classId));

        Attendance attendance = Attendance.builder()
                .studentName(dto.getStudentName())
                .present(dto.isPresent())
                .classSession(session)
                .build();

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByClass(Long classId) {
        ClassSession session = classRepository.findById(classId)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found with id: " + classId));
        return session.getAttendanceList();
    }
}

