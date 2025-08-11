package com.example.MovieBookingSystem.controller;

import com.example.MovieBookingSystem.model.Booking;
import com.example.MovieBookingSystem.model.Movie;
import com.example.MovieBookingSystem.model.Theater;
import com.example.MovieBookingSystem.model.Customer;
import com.example.MovieBookingSystem.repository.BookingRepository;
import com.example.MovieBookingSystem.repository.MovieRepository;
import com.example.MovieBookingSystem.repository.TheaterRepository;
import com.example.MovieBookingSystem.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a booking
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        // Check if movie, theater, and customer exist
        if (booking.getMovie() == null || booking.getTheater() == null || booking.getCustomer() == null) {
            return ResponseEntity.badRequest().body("Movie, Theater, and Customer must not be null");
        }

        Long movieId = booking.getMovie().getId();
        Long theaterId = booking.getTheater().getId();
        Long customerId = booking.getCustomer().getId();

        Movie movie = movieRepository.findById(movieId).orElse(null);
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (movie == null || theater == null || customer == null) {
            return ResponseEntity.badRequest().body("Invalid movie, theater, or customer ID");
        }

        booking.setMovie(movie);
        booking.setTheater(theater);
        booking.setCustomer(customer);

        return ResponseEntity.ok(bookingRepository.save(booking));
    }

    // Update booking (e.g., change seats or date)
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setSeats(updatedBooking.getSeats());
            booking.setBookingDate(updatedBooking.getBookingDate());
            return ResponseEntity.ok(bookingRepository.save(booking));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
