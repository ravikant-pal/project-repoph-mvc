package com.alok.repoph.services;

import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.repository.UtilityUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UtilityUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserService.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UtilityUserDetailService utilityUserDetailService;

    @Autowired
    UtilityUserDao utilityUserDao;




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

    public String registerUtilityUser(UtilityUser utilityUser) throws Exception {
        LOGGER.info(">>>>Entering into registerServiceUserController ");
        UtilityUser utilityUserFromDatabase;
        utilityUserFromDatabase = utilityUserDao.findByEmail(utilityUser.getEmail());
        String message = "";
        if (utilityUserFromDatabase != null) {
            message = "This username already exists! Please try another ";
            return message;
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
            message = "You are successfully Registered! Please login ";
        }

        LOGGER.info("<<<<<Exiting from registerController ");
        return message;
    }
    public UtilityUser findByEmail(String email) {
        return utilityUserDao.findByEmail(email);
    }

    public List<UtilityUser> findAllUtilityUsers() {
        return utilityUserDao.findAllByRole("SERVICE_USER");
    }




}
