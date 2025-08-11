package com.example.MovieBookingSystem.repository;

import com.example.MovieBookingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
