package com.alok.repoph.services;


import com.alok.repoph.dto.UserRegistrationDto;
import com.alok.repoph.models.Role;
import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.repository.UtilityUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UtilityUserServiceImpl implements UserService {
    @Autowired
    private UtilityUserDao utilityUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UtilityUser findByEmail(String email){
        return utilityUserDao.findByEmail(email);
    }

    public UtilityUser save(UserRegistrationDto registration){
        UtilityUser user = new UtilityUser();
        user.setFullName(registration.getFullName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return utilityUserDao.save(user);
    }

    @Override
    public void updatePassword(String password, Long userId) {
        utilityUserDao.updatePassword(password, userId);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilityUser utilityUser = utilityUserDao.findByEmail(email);
        if(utilityUser ==null) {
            throw  new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(utilityUser.getEmail(), utilityUser.getPassword(), mapRolesToAuthorities(utilityUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
