package com.alok.repoph.services;


import com.alok.repoph.web.dto.UserRegistrationDto;
import com.alok.repoph.models.Role;
import com.alok.repoph.models.User;
import com.alok.repoph.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public String saveUser(UserRegistrationDto registration){

        LOGGER.info(">>>>Entering into saveUser ");
        User userFromDatabase = userDao.findByEmail(registration.getEmail());
        String message = "";
        if (userFromDatabase != null) {
            message = "This username already exists! Please try another ";
            return message;
        } else {
            User user = new User();
            user.setFirstName(registration.getFirstName());
            user.setLastName(registration.getLastName());
            user.setEmail(registration.getEmail());
            user.setPassword(passwordEncoder.encode(registration.getPassword()));
            if(registration.getRole()) {
                user.setRoles(Collections.singletonList(new Role("SERVICE_USER")));
            } else  {
                user.setRoles(Collections.singletonList(new Role("END_USER")));
            }
            userDao.save(user);
            message = "You are successfully Registered! Please login ";
        }
        LOGGER.info("<<<<<Exiting from registerController ");
        return message;
    }

    @Override
    public void updatePassword(String password, Long userId) {
        userDao.updatePassword(password, userId);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if(user ==null) {
            throw  new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
