package com.alok.repoph.services;


import com.alok.repoph.pojo.About;
import com.alok.repoph.pojo.Address;
import com.alok.repoph.pojo.NationalId;
import com.alok.repoph.pojo.Skill;
import com.alok.repoph.web.dto.AboutDto;
import com.alok.repoph.web.dto.ContactDto;
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
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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
            user.setGender(registration.getGender());
            userDao.save(user);
            message = "You are successfully Registered! Please login ";
        }
        LOGGER.info("<<<<<Exiting from registerController ");
        return message;
    }

    public String saveAddress(Address address, Principal principal){
        LOGGER.info(">>>>Entering into saveAddress ");
        User user = userDao.findByEmail(principal.getName());
        user.setAddress(address);
        userDao.save(user);
        String message ="You are successfully Updated Address.";
        LOGGER.info("<<<<<Exiting from saveAddress ");
        return message;
    }

    public String saveContact(ContactDto contact, Principal principal){
        LOGGER.info(">>>>Entering into saveContact ");
        User user = userDao.findByEmail(principal.getName());
        user.setEmail(contact.getEmail());
        user.setMobileNumber(contact.getMobileNumber());
        userDao.save(user);
        String message ="You are successfully Updated Contact.";
        LOGGER.info("<<<<<Exiting from saveContact ");
        return message;
    }

    public String saveNationalId(NationalId nationalId, Principal principal){
        LOGGER.info(">>>>Entering into saveNationalId ");
        User user = userDao.findByEmail(principal.getName());
        user.setNationalId(nationalId);
        userDao.save(user);
        String message ="You are successfully Updated National Id.";
        LOGGER.info("<<<<<Exiting from saveContact ");
        return message;
    }

    public String saveSkillsAndPricing(List<Skill> skills,Double pricing, Principal principal){
        LOGGER.info(">>>>Entering into saveSkills ");
        User user = userDao.findByEmail(principal.getName());
        user.setSkills(skills);
        user.setPricing(pricing);
        userDao.save(user);
        String message ="You are successfully Updated Skills.";
        LOGGER.info("<<<<<Exiting from saveSkills ");
        return message;
    }

    public String updateRole(Boolean roleFlag, Principal principal){
        LOGGER.info(">>>>Entering into updateRole ");
        User user = userDao.findByEmail(principal.getName());
        Role role = (Role) user.getRoles().toArray()[0];
        if(roleFlag) {
            role.setName("SERVICE_USER");
        } else  {
            role.setName("END_USER");
        }
        user.setRoles(Collections.singletonList(role));
        String message ="You are successfully Updated Role.";
        LOGGER.info("<<<<<Exiting from updateRole ");
        return message;
    }

    public String updateAbout(AboutDto form, Principal principal){
        LOGGER.info(">>>>Entering into updateAbout ");
        User user = userDao.findByEmail(principal.getName());
        user.setAbout(new About(form.getTitle(),form.getDescription()));
        String message ="You are successfully Updated About yourself.";
        LOGGER.info("<<<<<Exiting from updateAbout ");
        return message;
    }

    @Override
    public void updatePassword(String password, Long userId) {
        userDao.updatePassword(password, userId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email------->"+email);
        User user = userDao.findByEmail(email);
        System.out.println("pass--->"+user.getPassword());
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
