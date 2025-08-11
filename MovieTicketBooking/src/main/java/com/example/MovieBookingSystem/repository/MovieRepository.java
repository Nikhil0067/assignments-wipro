package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
