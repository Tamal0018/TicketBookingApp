package com.jts.OnlineTicketBookingApp.convertors;

import com.jts.OnlineTicketBookingApp.models.Show;
import com.jts.OnlineTicketBookingApp.models.Ticket;
import com.jts.OnlineTicketBookingApp.responses.TicketResponse;

public class TicketConvertor {

    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}