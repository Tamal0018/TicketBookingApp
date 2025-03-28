package com.jts.OnlineTicketBookingApp.controllers;

import com.jts.OnlineTicketBookingApp.requests.MovieRequest;
import com.jts.OnlineTicketBookingApp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

        @Autowired
        private MovieService movieService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        System.out.println("Test endpoint hit!");
        return ResponseEntity.ok("Test successful");
    }

    @PostMapping("/addNew")
        public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest) {
            System.out.println("Inside addNew");

            try {
                String result = movieService.addMovie(movieRequest);
                System.out.println("Added");
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
}
