package com.jts.OnlineTicketBookingApp.exceptions;

import java.io.Serial;

public class MovieAlreadyExists extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 87214071728310561L;

    public MovieAlreadyExists() {
        super("Movie is already exists with same name and language");
    }
}