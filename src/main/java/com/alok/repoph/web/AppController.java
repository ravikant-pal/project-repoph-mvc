package com.alok.repoph.web;

import com.alok.repoph.models.User;
import com.alok.repoph.services.AppService;
import com.alok.repoph.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService appService;

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

}
