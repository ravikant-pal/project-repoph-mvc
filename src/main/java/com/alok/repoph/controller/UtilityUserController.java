package com.alok.repoph.controller;

import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/login")
    public String loadLogInForm(Principal principal) {
        if (principal != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }
}
