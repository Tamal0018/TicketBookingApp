package com.jts.OnlineTicketBookingApp.services;

import java.util.List;
import java.util.Optional;

import com.jts.OnlineTicketBookingApp.enums.SeatTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.OnlineTicketBookingApp.convertors.ShowConvertor;
import com.jts.OnlineTicketBookingApp.models.Movie;
import com.jts.OnlineTicketBookingApp.models.Show;
import com.jts.OnlineTicketBookingApp.models.ShowSeat;
import com.jts.OnlineTicketBookingApp.models.Theater;
import com.jts.OnlineTicketBookingApp.models.TheaterSeat;
import com.jts.OnlineTicketBookingApp.exceptions.MovieDoesNotExist;
import com.jts.OnlineTicketBookingApp.exceptions.ShowDoesNotExist;
import com.jts.OnlineTicketBookingApp.exceptions.TheaterDoesNotExist;
import com.jts.OnlineTicketBookingApp.repositories.MovieRepository;
import com.jts.OnlineTicketBookingApp.repositories.ShowRepository;
import com.jts.OnlineTicketBookingApp.repositories.TheaterRepository;
import com.jts.OnlineTicketBookingApp.requests.ShowRequest;
import com.jts.OnlineTicketBookingApp.requests.ShowSeatRequest;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

        if (movieOpt.isEmpty()) {
            throw new MovieDoesNotExist();
        }

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

        if (theaterOpt.isEmpty()) {
            throw new TheaterDoesNotExist();
        }

        Theater theater = theaterOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added Successfully";
    }

    public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExist {
        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

        if (showOpt.isEmpty()) {
            throw new ShowDoesNotExist();
        }

        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if (showSeat.getSeatType().equals(SeatTypes.Economy)) {
                showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
            } else {
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add(showSeat);
        }

        showRepository.save(show);

        return "Show seats have been associated successfully";
    }
}