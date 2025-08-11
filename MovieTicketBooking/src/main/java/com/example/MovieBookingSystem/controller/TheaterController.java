package com.example.MovieBookingSystem.controller;

import com.example.MovieBookingSystem.model.Theater;
import com.example.MovieBookingSystem.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    @Autowired
    private TheaterRepository theaterRepository;

    // Get all theaters
    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    // Get theater by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        return theaterRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add new theater
    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterRepository.save(theater);
    }

    // Update existing theater
    @PutMapping("/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater updatedTheater) {
        return theaterRepository.findById(id).map(theater -> {
            theater.setName(updatedTheater.getName());
            theater.setLocation(updatedTheater.getLocation());
            return ResponseEntity.ok(theaterRepository.save(theater));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a theater
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        if (theaterRepository.existsById(id)) {
            theaterRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
