package com.jts.OnlineTicketBookingApp.requests;

import lombok.Data;

import java.sql.Date;

import com.jts.OnlineTicketBookingApp.enums.Languages;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private String genre;
    private Languages language;
}