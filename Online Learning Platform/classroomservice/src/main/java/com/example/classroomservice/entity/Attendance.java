package com.example.classroomservice.entity;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private boolean present;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassSession classSession;
}
