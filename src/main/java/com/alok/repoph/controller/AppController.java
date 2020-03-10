package com.alok.repoph.controller;

import com.alok.repoph.common.utils.CommonHelperFunctions;
import com.alok.repoph.common.utils.Constants;
import com.alok.repoph.exception.UserAlreadyHiredException;
import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.pojo.ApiResponse;
import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    UtilityUserService utilityUserService;

    @GetMapping
    public String loadHomePage() {
        return "home";
    }
    @GetMapping("/hire")
    public ResponseEntity<?> selectPeople(@RequestParam("id") Long id, Principal principal) throws UserAlreadyHiredException {
        LOGGER.info(">>>>>Entering into select ");
        try {
            ApiResponse apiResponse = utilityUserService.selectPeople(id,principal);
            LOGGER.info("<<<<<Exiting from select");
            return CommonHelperFunctions.buildResponseEntity(apiResponse);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from select");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }

    @GetMapping("/allUtilityUser")
    public ResponseEntity<?> getAllUtilityUser() {
        LOGGER.info(">>>>>Entering into getAllUtilityUser");
        try {
            List<UtilityUser> listOfUtilityUser= utilityUserService.findAllUtilityUsers();
            LOGGER.info("<<<<<Exiting from getAllUtilityUser");
            return CommonHelperFunctions.buildResponseEntity (new ApiResponse(HttpStatus.OK, Constants.SUCCESS_MESSAGE, listOfUtilityUser));
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from getAllUtilityUser");
            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
        }
    }
}
