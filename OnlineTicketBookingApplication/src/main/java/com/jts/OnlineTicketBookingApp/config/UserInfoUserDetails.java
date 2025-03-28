package com.jts.OnlineTicketBookingApp.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jts.OnlineTicketBookingApp.models.User;

public class UserInfoUserDetails implements UserDetails {

    private static final long serialVersionUID = -8773921465190832995L;
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User userInfo) {
        name = userInfo.getEmailId();
        password = userInfo.getPassword();
        authorities = Collections.singletonList(
                new SimpleGrantedAuthority(userInfo.getRoles().name())
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

}