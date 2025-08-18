package com.example.classroomservice.controller;



import com.example.classroomservice.dto.ClassDTO;
import com.example.classroomservice.dto.AttendanceDTO;
import com.example.classroomservice.entity.Attendance;
import com.example.classroomservice.entity.ClassSession;
import com.example.classroomservice.service.ClassService;
import com.example.classroomservice.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;
    private final AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<ClassSession> createClass(@RequestBody ClassDTO dto) {
        return ResponseEntity.ok(classService.createClass(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClassSession>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSession> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PostMapping("/{id}/attendance")
    public ResponseEntity<Attendance> markAttendance(@PathVariable Long id, @RequestBody AttendanceDTO dto) {
        return ResponseEntity.ok(attendanceService.markAttendance(id, dto));
    }

    @GetMapping("/{id}/attendance")
    public ResponseEntity<List<Attendance>> getAttendance(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getAttendanceByClass(id));
    }
}
