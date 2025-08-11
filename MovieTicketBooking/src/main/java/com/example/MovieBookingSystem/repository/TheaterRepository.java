package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
