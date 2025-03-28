package com.jts.OnlineTicketBookingApp.exceptions;

import java.io.Serial;

public class TheaterDoesNotExist extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2885350098352987873L;

    public TheaterDoesNotExist() {
        super("Theater does not Exists");
    }
}