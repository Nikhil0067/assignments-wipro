package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
