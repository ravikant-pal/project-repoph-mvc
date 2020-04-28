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
import java.util.ArrayList;
import java.util.Arrays;
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
    public String placeOrder(
            @RequestParam("hours") String hours,
            @RequestParam("ids") String ids,
            Model model) {

        System.out.println(hours);
        System.out.println(ids);

        return "ask-hours";
    }

}
