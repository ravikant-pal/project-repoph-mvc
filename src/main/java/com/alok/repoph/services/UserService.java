package com.alok.repoph.services;

import com.alok.repoph.web.dto.UserRegistrationDto;
import com.alok.repoph.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    String saveUser(UserRegistrationDto registration);

    void updatePassword(String password, Long userId);
}
