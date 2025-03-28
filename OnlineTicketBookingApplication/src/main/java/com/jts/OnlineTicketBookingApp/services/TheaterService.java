package com.jts.OnlineTicketBookingApp.services;

import com.jts.OnlineTicketBookingApp.enums.SeatTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jts.OnlineTicketBookingApp.convertors.TheaterConvertor;
import com.jts.OnlineTicketBookingApp.models.Theater;
import com.jts.OnlineTicketBookingApp.models.TheaterSeat;
import com.jts.OnlineTicketBookingApp.exceptions.TheaterAlreadyExists;
import com.jts.OnlineTicketBookingApp.exceptions.TheaterDoesNotExist;
import com.jts.OnlineTicketBookingApp.repositories.TheaterRepository;
import com.jts.OnlineTicketBookingApp.requests.TheaterRequest;
import com.jts.OnlineTicketBookingApp.requests.TheaterSeatRequest;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(TheaterRequest theaterRequest) throws TheaterAlreadyExists {
        if (theaterRepository.findByAddress(theaterRequest.getAddress()) != null) {
            throw new TheaterAlreadyExists();
        }

        Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);

        theaterRepository.save(theater);
        return "Theater has been saved Successfully";
    }

    public String addTheaterSeat(TheaterSeatRequest entryDto) throws TheaterDoesNotExist {
        if (theaterRepository.findByAddress(entryDto.getAddress()) == null) {
            throw new TheaterDoesNotExist();
        }

        Integer noOfSeatsInRow = entryDto.getNoOfSeatInRow();
        Integer noOfPremiumSeats = entryDto.getNoOfPremiumSeat();
        Integer noOfClassicSeat = entryDto.getNoOfClassicSeat();
        String address = entryDto.getAddress();

        Theater theater = theaterRepository.findByAddress(address);

        List<TheaterSeat> seatList = theater.getTheaterSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for (int i = 1; i <= noOfClassicSeat; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if (fill == noOfSeatsInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatTypes.Economy);
            theaterSeat.setTheater(theater);
            seatList.add(theaterSeat);
        }

        for (int i = 1; i <= noOfPremiumSeats; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if (fill == noOfSeatsInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatTypes.Premium);
            theaterSeat.setTheater(theater);
            seatList.add(theaterSeat);
        }

        theaterRepository.save(theater);

        return "Theater Seats have been added successfully";
    }
}