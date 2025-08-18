package com.example.classroomservice.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {
    private String studentName;
    private boolean present;
}
