package com.alok.repoph.web;

import com.alok.repoph.models.User;
import com.alok.repoph.services.AppService;
import com.alok.repoph.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService appService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/home")
    public String loadHomePage(Model model) {
        List<User> userList = new ArrayList<>();
        try {
            userList = appService.getAllUsers();
        } catch (Exception e) {
            LOGGER.info("Something went wrong");
        }
        model.addAttribute("data",userList);
        return "home";
    }
    @GetMapping("/public-profile/{id}")
    public String loadPublicProfilePage(Model model, @PathVariable Long id) {
        User user = new User();
        try {
            user = appService.getUserById(id);
        } catch (Exception e) {
            LOGGER.info("Something went wrong");
        }
        model.addAttribute("publicProfile",user);
        return "public-profile";
    }


    @PostMapping("/add-to-cart")
    public String addToCart(
            @RequestParam("id") String ids, Model model) {

        List<User> userTobeHire = new ArrayList<>();
        String[] usersIdsList = ids.split(",");
        Arrays.asList(usersIdsList).forEach(id -> {
            userTobeHire.add(appService.getUserById(Long.parseLong(id)));
        });
        model.addAttribute("userTobeHire",userTobeHire);
        return "ask-hours";
    }


    @PostMapping("/place-order")
    public String placeOrderController(
            @RequestParam("hours") Double estTime,
            @RequestParam("ids") String ids,
            Model model,
            Principal principal) {
        LOGGER.info(">>>>>Entering into placeOrderController");
        String message;
        try {
            message= appService.hire(estTime,ids,principal);
            LOGGER.info("<<<<<Exiting from updateAboutController");
            model.addAttribute("msg",message);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateAboutController");
            model.addAttribute("msg","Something went wrong !");
            return "hired-success";
        }
        return "hired-success";
    }

    @GetMapping("/my-hiring")
    public String myOrderController(
            Model model,
            Principal principal) {
        LOGGER.info(">>>>>Entering into myOrderController");
        try {
            List<User> listOfHiredPeople= userService.findByEmail(principal.getName()).getListOfHiredPeople();
            LOGGER.info("<<<<<Exiting from myOrderController");
            model.addAttribute("listOfHiredPeople",listOfHiredPeople);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from myOrderController");
            model.addAttribute("msg","Something went wrong !");
            return "order-details";
        }
        return "order-details";
    }

    @GetMapping("/who-hire-me")
    public String whoHireMeController(
            Model model,
            Principal principal) {
        LOGGER.info(">>>>>Entering into whoHireMeController");
        try {
            User user = userService.findByEmail(principal.getName());
            LOGGER.info("<<<<<Exiting from whoHireMeController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from whoHireMeController");
            model.addAttribute("msg","Something went wrong !");
            return "who-hired-me";
        }
        return "who-hired-me";
    }

    @GetMapping("/decline")
    public String declineController(
            Model model,
            Principal principal) {
        LOGGER.info(">>>>>Entering into declineController");
        try {
            User user = userService.findByEmail(principal.getName());
            user.setStatus("declined");
            userService.save(user);
            LOGGER.info("<<<<<Exiting from declineController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from declineController");
            model.addAttribute("msg","Something went wrong !");
            return "who-hired-me";
        }
        return "who-hired-me";
    }

    @GetMapping("/accept")
    public String acceptController(
            Model model,
            Principal principal) {
        LOGGER.info(">>>>>Entering into acceptController");
        try {
            User user = userService.findByEmail(principal.getName());
            user.setStatus("running");
            user.setHireStatus(true);
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
//            Date current  = new Date();
//            dateFormat.format(current);
            user.setHiredStartTime(LocalTime.now());
            userService.save(user);
            LOGGER.info("<<<<<Exiting from acceptController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from acceptController");
            model.addAttribute("msg","Something went wrong !");
            return "who-hired-me";
        }
        return "who-hired-me";
    }

    @GetMapping("/cancel/{id}")
    public String cancelController(
            Model model,
            Principal principal, @PathVariable Long id) {
        LOGGER.info(">>>>>Entering into cancelController");
        try {
            User user = appService.getUserById(id);
            user.setStatus("cancel");
            userService.save(user);
            LOGGER.info("<<<<<Exiting from cancelController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from cancelController");
            model.addAttribute("msg","Something went wrong !");
            return "redirect:/my-hiring";
        }
        return "redirect:/my-hiring";
    }

//    @GetMapping("/endSession/{id}")
//    public String endSessionController(
//            Model model,
//            Principal principal, @PathVariable Long id) {
//        LOGGER.info(">>>>>Entering into endSessionController");
//        try {
//            User user = appService.getUserById(id);
//            user.setStatus("cancel");
//            userService.save(user);
//            LOGGER.info("<<<<<Exiting from endSessionController");
//            model.addAttribute("me",user);
//        } catch (Exception e) {
//            LOGGER.info("<<<<<Exiting from endSessionController");
//            model.addAttribute("msg","Something went wrong !");
//            return "redirect:/my-hiring";
//        }
//        return "redirect:/my-hiring";
//    }

}
