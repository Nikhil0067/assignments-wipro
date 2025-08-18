package com.example.courseservice.service;

import com.example.courseservice.model.Course;
import com.example.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create a new course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update syllabus
    public Course updateSyllabus(Long courseId, String syllabus) {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();
            course.setSyllabus(syllabus);
            return courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    // Enroll a student
    public void enrollStudent(Long courseId, String studentName) {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();
            course.getEnrolledStudents().add(studentName);
            courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
