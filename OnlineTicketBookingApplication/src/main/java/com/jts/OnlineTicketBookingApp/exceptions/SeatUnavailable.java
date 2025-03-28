package com.jts.OnlineTicketBookingApp.exceptions;

import java.io.Serial;

public class SeatUnavailable extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1497113945165128412L;

    public SeatUnavailable() {
        super("Requested Seats Are Not Available");
    }
}