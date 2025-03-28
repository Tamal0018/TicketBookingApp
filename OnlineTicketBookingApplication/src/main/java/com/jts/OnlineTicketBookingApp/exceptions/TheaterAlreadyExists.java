package com.jts.OnlineTicketBookingApp.exceptions;

import java.io.Serial;

public class TheaterAlreadyExists extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 6386810783666583528L;

    public TheaterAlreadyExists() {
        super("Theater is already Present on this Address");
    }
}