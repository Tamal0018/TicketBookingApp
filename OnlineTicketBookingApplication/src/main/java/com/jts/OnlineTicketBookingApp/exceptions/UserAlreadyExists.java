package com.jts.OnlineTicketBookingApp.exceptions;

import java.io.Serial;

public class UserAlreadyExists extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4666349320340656440L;

    public UserAlreadyExists() {
        super("User Already Exists with this EmailId");
    }
}