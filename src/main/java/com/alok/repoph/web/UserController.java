package com.alok.repoph.web;

import com.alok.repoph.services.UserServiceImpl;
import com.alok.repoph.services.UtilityUserService;
import com.alok.repoph.web.dto.UserRegistrationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UtilityUserService utilityUserService;

    @Autowired
    UserServiceImpl userService;




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
    @ModelAttribute("registrationForm")
    public UserRegistrationDto forgotPasswordDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String loadRegisterForm() {
        return "user-registration";
    }

    @PostMapping("/registration")
    public String registerEndUser(@ModelAttribute("registrationForm") @Valid UserRegistrationDto form,
                                  BindingResult result, Model model,@RequestParam("serviceOrEnd") Boolean role , RedirectAttributes redirectAttributes) {
        System.out.println("-------------------"+role);
        LOGGER.info(">>>>>Entering into registerController");
        String message;
        try {
             message= userService.saveUser(form);
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg",message);
            if(message.contains("already")) {
                return "user-registration";
            }

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","Something went wrong !");
            return "user-registration";
        }
        //redirectAttributes.addAttribute("string", "this will be converted into string, if not already");
        redirectAttributes.addFlashAttribute("msg" ,message);
        return "redirect:/login";
    }
}
