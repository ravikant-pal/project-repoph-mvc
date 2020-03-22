package com.alok.repoph.controller;

import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilityUser")
public class UtilityUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserController.class);

    @Autowired
    UtilityUserService utilityUserService;


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
            String message = utilityUserService.registerUtilityUser(utilityUser);
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg",message);
            if(message.contains("already")) {
                return "register";
            }

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","Something went wrong !");
        }
        return "redirect:/utilityUser/login";
    }

}
