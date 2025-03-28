package com.jts.OnlineTicketBookingApp.services;

import com.jts.OnlineTicketBookingApp.convertors.UserConvertor;
import com.jts.OnlineTicketBookingApp.exceptions.UserAlreadyExists;
import com.jts.OnlineTicketBookingApp.models.User;
import com.jts.OnlineTicketBookingApp.repositories.UserRepository;
import com.jts.OnlineTicketBookingApp.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserRequest userRequest) {
        Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());

        if (users.isPresent()) {
            throw new UserAlreadyExists();
        }

        User user = UserConvertor.userDtoToUser(userRequest, passwordEncoder.encode("1234"));

        userRepository.save(user);
        return "User Saved Successfully";
    }
}
