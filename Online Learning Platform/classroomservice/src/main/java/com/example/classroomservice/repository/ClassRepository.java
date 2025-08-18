package com.example.classroomservice.repository;



import com.example.classroomservice.entity.ClassSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassSession, Long> {
}
