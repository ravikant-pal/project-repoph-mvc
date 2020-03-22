package com.alok.repoph.controller;

import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/utilityUser")
public class UtilityUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserController.class);

    @Autowired
    UtilityUserService utilityUserService;



//    @GetMapping("/getMyProfile")
//    public ResponseEntity<?> getProfile(Principal principal) {
//        LOGGER.info(">>>>>Entering into getProfile");
//        try {
//            UtilityUser utilityUser = utilityUserService.findByEmail(principal.getName());
//            LOGGER.info("<<<<<Exiting from getProfile");
//            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.OK,Constants.SUCCESS_MESSAGE,utilityUser));
//        } catch (Exception e) {
//            LOGGER.info("<<<<<Exiting from getProfile");
//            return CommonHelperFunctions.buildResponseEntity(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.INTERNAL_SERVER_ERROR_MESSAGE));
//        }
//    }

}
