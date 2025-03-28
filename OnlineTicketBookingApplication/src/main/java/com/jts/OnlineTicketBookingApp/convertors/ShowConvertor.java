package com.jts.OnlineTicketBookingApp.convertors;

import com.jts.OnlineTicketBookingApp.models.Show;
import com.jts.OnlineTicketBookingApp.requests.ShowRequest;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();

        return show;
    }
}