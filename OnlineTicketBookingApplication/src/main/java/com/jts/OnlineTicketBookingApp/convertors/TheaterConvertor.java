package com.jts.OnlineTicketBookingApp.convertors;

import com.jts.OnlineTicketBookingApp.models.Theater;
import com.jts.OnlineTicketBookingApp.requests.TheaterRequest;

public class TheaterConvertor {

    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
        Theater theater = Theater.builder()
                .name(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .build();
        return theater;
    }
}