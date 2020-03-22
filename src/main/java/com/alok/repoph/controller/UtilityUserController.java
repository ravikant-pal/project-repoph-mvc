package com.alok.repoph.controller;

import com.alok.repoph.common.utils.CommonHelperFunctions;
import com.alok.repoph.common.utils.Constants;
import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.pojo.ApiResponse;
import com.alok.repoph.pojo.AuthenticationRequest;
import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/utilityUser")
public class UtilityUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserController.class);

    @Autowired
    UtilityUserService utilityUserService;



    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        LOGGER.info(">>>>> Entering login controller");
        return utilityUserService.generateAuthenticationToken(authenticationRequest);

    }

    @GetMapping("/register")
    public String loadRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerEndUser(@ModelAttribute("userForm") UtilityUser utilityUser, @RequestParam( defaultValue = "false", required = false, name ="serviceOrEnd") Boolean serviceOrEnd,Model model ) {
        LOGGER.info(">>>>>Entering into registerController");
        System.out.println(utilityUser.getEmail()+" "+utilityUser.getFullName()+ " "+serviceOrEnd);
        if ((serviceOrEnd)) {
            utilityUser.setRole("service");
        } else {
            utilityUser.setRole("end");
        }
        try {
            ApiResponse apiResponse = utilityUserService.registerUtilityUser(utilityUser);
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","You are successfully Registered! Please login ");
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","Something went wrong !");
        }
        return "login";
    }

    @GetMapping("/login")
    public String loadLogInForm(Model model) {
        model.addAttribute("authentication",new AuthenticationRequest());
        return "login";
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<?> getProfile(Principal principal) {
        LOGGER.info(">>>>>Entering into getProfile");
        try {
            UtilityUser utilityUser = utilityUserService.findByEmail(principal.getName());
            LOGGER.info("<<<<<Exiting from getProfile");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.OK,Constants.SUCCESS_MESSAGE,utilityUser));
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from getProfile");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_MESSAGE));
        }
    }


}
