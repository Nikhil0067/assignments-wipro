package com.example.courseservice.controller;

import com.example.courseservice.model.Course;
import com.example.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @PutMapping("/{courseId}/syllabus")
    public ResponseEntity<Course> updateSyllabus(
            @PathVariable Long courseId,
            @RequestBody String syllabus) {
        return ResponseEntity.ok(courseService.updateSyllabus(courseId, syllabus));
    }

    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<String> enrollStudent(
            @PathVariable Long courseId,
            @RequestParam String studentName) {
        courseService.enrollStudent(courseId, studentName);
        return ResponseEntity.ok(studentName + " enrolled successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
