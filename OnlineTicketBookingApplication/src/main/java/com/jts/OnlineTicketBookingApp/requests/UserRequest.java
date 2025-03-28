package com.jts.OnlineTicketBookingApp.requests;

import com.jts.OnlineTicketBookingApp.enums.Gender;
import com.jts.OnlineTicketBookingApp.enums.Roles;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private Roles roles;

}