package com.jts.OnlineTicketBookingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jts.OnlineTicketBookingApp.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String name);
}