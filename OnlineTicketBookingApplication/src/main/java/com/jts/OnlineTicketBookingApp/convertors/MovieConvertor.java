package com.jts.OnlineTicketBookingApp.convertors;

import com.jts.OnlineTicketBookingApp.models.Movie;
import com.jts.OnlineTicketBookingApp.requests.MovieRequest;

public class MovieConvertor {

    public static Movie movieDtoToMovie(MovieRequest movieRequest) {
        Movie movie = Movie.builder()
                .movieName(movieRequest.getMovieName())
                .duration(movieRequest.getDuration())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .releaseDate(movieRequest.getReleaseDate())
                .rating(movieRequest.getRating())
                .build();

        return movie;
    }
}