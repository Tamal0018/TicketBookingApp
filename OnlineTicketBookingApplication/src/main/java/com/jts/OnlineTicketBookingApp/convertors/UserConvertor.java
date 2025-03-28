package com.jts.OnlineTicketBookingApp.convertors;

import com.jts.OnlineTicketBookingApp.models.User;
import com.jts.OnlineTicketBookingApp.requests.UserRequest;
import com.jts.OnlineTicketBookingApp.responses.UserResponse;

public class UserConvertor {

    public static User userDtoToUser(UserRequest userRequest, String password) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .gender(userRequest.getGender())
                .emailId(userRequest.getEmailId())
                .password(password)
                .roles(userRequest.getRoles())
                .build();

        return user;
    }

    public static UserResponse userToUserDto(User user) {
        UserResponse userDto = UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .gender(user.getGender())
                .build();

        return userDto;
    }
}