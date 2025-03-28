package com.jts.OnlineTicketBookingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jts.OnlineTicketBookingApp.models.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}