package com.alok.repoph.services;

import com.alok.repoph.exception.UserAlreadyHiredException;
import com.alok.repoph.jwt.utils.JwtUtil;
import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.pojo.ApiResponse;
import com.alok.repoph.pojo.AuthenticationRequest;
import com.alok.repoph.pojo.AuthenticationResponse;
import com.alok.repoph.repository.UtilityUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UtilityUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserService.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilityUserDetailService utilityUserDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    UtilityUserDao utilityUserDao;

    public ApiResponse registerUtilityUser(UtilityUser utilityUser) throws Exception {
        LOGGER.info(">>>>Entering into registerServiceUserController ");
        UtilityUser utilityUserFromDatabase;
        utilityUserFromDatabase = utilityUserDao.findByEmail(utilityUser.getEmail());
        String message = "";
        if (utilityUserFromDatabase != null) {
            message = "Service Agent with this username already exists";
            return new ApiResponse(HttpStatus.OK, "success", message);
        } else {
            if(utilityUser.getRole().equalsIgnoreCase("service")) {
                utilityUser.setRole("SERVICE_USER");
            }
            else  {
                utilityUser.setRole("END_USER");
            }
            String encryptedPassword = passwordEncoder.encode(utilityUser.getPassword());
            utilityUser.setPassword(encryptedPassword);
            utilityUserDao.save(utilityUser);
            message = "Service User successfully registered";
        }

        LOGGER.info("<<<<<Exiting from registerController ");
        return new ApiResponse(HttpStatus.OK, "success", message);
    }


    public ApiResponse selectPeople(Long id, Principal principal) throws Exception {
        LOGGER.info(">>>>Entering into selectPeople ");
        UtilityUser userWithID = utilityUserDao.findById(id).get();

        String message="";
        System.out.println(userWithID.getHireStatus());
        if(!userWithID.getHireStatus()) {
            UtilityUser loggedInUser = utilityUserDao.findByEmail(principal.getName());
            List<UtilityUser> listOfHiredPeople = loggedInUser.getListOfHiredPeople();
            listOfHiredPeople.add(userWithID);
            userWithID.setHireStatus(true);

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.HOUR, -1);
            Date oneHourBack = cal.getTime();
            userWithID.setHireTime(oneHourBack);
             message = "User selected successfully !";
        }
        else  {
            throw new UserAlreadyHiredException("User already hired for this much period of time ");
        }


        return new ApiResponse(HttpStatus.OK, "success", message);

    }


    public ResponseEntity<?> generateAuthenticationToken(AuthenticationRequest authenticationRequest) {
        LOGGER.info(">>>>> Entering into jwt token generator ");
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    ));

        } catch (BadCredentialsException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            LOGGER.info("<<<<< Exiting from jwt token generator ");
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.FORBIDDEN);
        }


        final UserDetails userDetails = utilityUserDetailService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        LOGGER.info("<<<<< Exiting from jwt token generator ");
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }



    public UtilityUser findByEmail(String email) {
        return utilityUserDao.findByEmail(email);
    }

    public List<UtilityUser> findAllUtilityUsers() {
        return utilityUserDao.findAllByRole("SERVICE_USER");
    }




}
