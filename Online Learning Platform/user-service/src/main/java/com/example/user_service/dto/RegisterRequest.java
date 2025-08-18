package com.example.user_service.dto;


import com.example.user_service.entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @Email
    private String email;

    @NotBlank
    private String password;

    private String name;
    private Role role;
}