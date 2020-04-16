package com.alok.repoph.services;

import com.alok.repoph.dto.UserRegistrationDto;
import com.alok.repoph.models.UtilityUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UtilityUser findByEmail(String email);

    UtilityUser save(UserRegistrationDto registration);

    void updatePassword(String password, Long userId);
}
