package com.jts.OnlineTicketBookingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jts.OnlineTicketBookingApp.models.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByUser_EmailId(String emailId);
}