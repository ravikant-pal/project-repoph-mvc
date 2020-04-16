package com.alok.repoph.controller;

import com.alok.repoph.models.UtilityUser;
import com.alok.repoph.services.UtilityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class UtilityUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilityUserController.class);

    @Autowired
    UtilityUserService utilityUserService;


    @GetMapping("/login")
    public String loadLogInForm(@ModelAttribute("msg") String message,Principal principal,Model model) {
        if (principal != null) {
            return "redirect:/";
        } else {
            model.addAttribute("msg",message);
            return "login";
        }
    }
    @RequestMapping("/login-error")
    public String loadLogInFormWithError(Principal principal,Model model) {
        if (principal != null) {
            return "redirect:/";
        } else {
            model.addAttribute("msg","Incorrect username or password");
            return "login";
        }
    }
    @GetMapping("/registration")
    public String loadRegisterForm() {
        return "register";
    }

    @PostMapping("/registration")
    public String registerEndUser(@ModelAttribute("userForm") UtilityUser utilityUser, @RequestParam( defaultValue = "false", required = false, name ="serviceOrEnd") Boolean serviceOrEnd, Model model , RedirectAttributes redirectAttributes) {
        LOGGER.info(">>>>>Entering into registerController");
        System.out.println(utilityUser.getEmail()+" "+utilityUser.getFullName()+ " "+serviceOrEnd);
        String message =null;
        if ((serviceOrEnd)) {
            utilityUser.setRole("service");
        } else {
            utilityUser.setRole("end");
        }
        try {
             message= utilityUserService.registerUtilityUser(utilityUser);
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg",message);
            if(message.contains("already")) {
                return "register";
            }

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","Something went wrong !");
        }
        //redirectAttributes.addAttribute("string", "this will be converted into string, if not already");
        redirectAttributes.addFlashAttribute("msg" ,message);
        return "redirect:/login";
    }
}
