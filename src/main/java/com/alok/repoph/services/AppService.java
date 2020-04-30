package com.alok.repoph.services;

import com.alok.repoph.models.User;
import com.alok.repoph.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@Transactional
public class AppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    @Autowired
    UserDao userDao;



//    public ResponseEntity<?> generateAuthenticationToken(AuthenticationRequest authenticationRequest) {
//        LOGGER.info(">>>>> Entering into jwt token generator ");
//        try {
//
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUsername(),
//                            authenticationRequest.getPassword()
//                    ));
//
//        } catch (BadCredentialsException e) {
//            LOGGER.error(Arrays.toString(e.getStackTrace()));
//            LOGGER.info("<<<<< Exiting from jwt token generator ");
//            return new ResponseEntity<>("Incorrect username or password", HttpStatus.FORBIDDEN);
//        }
//
//
//        final UserDetails userDetails = utilityUserDetailService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        LOGGER.info("<<<<< Exiting from jwt token generator ");
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }

//    public String registerUtilityUser(User user) throws Exception {
//        LOGGER.info(">>>>Entering into registerServiceUserController ");
//        User userFromDatabase;
//        userFromDatabase = userDao.findByEmail(user.getEmail());
//        String message = "";
//        if (userFromDatabase != null) {
//            message = "This username already exists! Please try another ";
//            return message;
//        } else {
//            if(user.getRole().equalsIgnoreCase("service")) {
//                user.setRole("SERVICE_USER");
//            }
//            else  {
//                user.setRole("END_USER");
//            }
//            String encryptedPassword = passwordEncoder.encode(user.getPassword());
//            user.setPassword(encryptedPassword);
//            userDao.save(user);
//            message = "You are successfully Registered! Please login ";
//        }
//
//        LOGGER.info("<<<<<Exiting from registerController ");
//        return message;
//    }
    public User getUserById(Long id) {
        return userDao.findById(id).get();
    }

    public List<User> getAllUsers() {
        return userDao.findAllByIsProfileCompleted(true);
    }

    public String hire(Double estTime,String ids, Principal principal){
        LOGGER.info(">>>>Entering into hire ");
        User endUser = userDao.findByEmail(principal.getName());
        List<User> hiredUser = new ArrayList<>();
        String[] usersIdsList = ids.split(",");
        Arrays.asList(usersIdsList).forEach(id -> {
            User user = userDao.findById(Long.parseLong(id)).get();
            user.setEstimatedTime(estTime);
            user.setHireStatus(true);
            user.setWhoHiredMe(endUser);
            hiredUser.add(user);
        });
        endUser.setListOfHiredPeople(hiredUser);
        String message ="Your hiring is successful !";
        LOGGER.info("<<<<<Exiting from updateAbout ");
        return message;
    }
}
