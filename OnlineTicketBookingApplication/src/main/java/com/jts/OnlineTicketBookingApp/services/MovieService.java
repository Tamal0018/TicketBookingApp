package com.jts.OnlineTicketBookingApp.services;

import com.jts.OnlineTicketBookingApp.exceptions.MovieAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.OnlineTicketBookingApp.convertors.MovieConvertor;
import com.jts.OnlineTicketBookingApp.models.Movie;
import com.jts.OnlineTicketBookingApp.repositories.MovieRepository;
import com.jts.OnlineTicketBookingApp.requests.MovieRequest;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
            throw new MovieAlreadyExists();
        }

        Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }
}