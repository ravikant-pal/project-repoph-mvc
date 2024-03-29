package com.alok.repoph.web;

import com.alok.repoph.models.Role;
import com.alok.repoph.models.User;
import com.alok.repoph.services.AppService;
import com.alok.repoph.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class AppController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    AppService appService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String loadHomePage(Model model,@ModelAttribute("userType") String userType,
                               @ModelAttribute("msg") String msg,
                               @RequestParam(required = false, name = "q") String keyword,
                               @RequestParam(required = false, name = "sortBy") String sortBy,
                               @RequestParam(required = false, name = "price") Double price,
                               @RequestParam(required = false, name = "lat") Double lat,
                               @RequestParam(required = false, name = "lan") Double lan,
                               Principal principal) {
        //System.out.println(keyword+"==============>"+lat+" "+lan);
        List<User> userList = new ArrayList<>();
        User active;
        try {
            if(principal!=null) {
                active = userService.findByEmail(principal.getName());
                if(userType.equals("")) {
                    Collection<Role> roles = active.getRoles();
                    List<Role> theList = new ArrayList<>(roles);
                    if(theList.get(0).getName().equals("SERVICE_USER")) {
                        model.addAttribute("userType","spFh");
                    } else  {
                        model.addAttribute("userType","sc");
                    }
                } else  {
                    model.addAttribute("userType",userType);
                }
                model.addAttribute("activeUsername",active.getFirstName()+' '+active.getLastName());
            }
            userList = appService.getAllSortedAndFilteredUsers(price,sortBy,lat,lan,keyword);
        } catch (Exception e) {
            LOGGER.info("Something went wrong");
        }
        if(msg!=null) {
            model.addAttribute("msg",msg);
        }
        model.addAttribute("data",userList);
        if(keyword!=null && !keyword.equals(""))
            model.addAttribute("keyword",keyword);
        if(price!=null)
            model.addAttribute("price",price);
        if(lan!=null)
            model.addAttribute("nearme","nearme");
        if(sortBy!=null)
            model.addAttribute("sortBy",sortBy);
        else
            model.addAttribute("sortBy","");
        return "home";
    }
    @GetMapping("/public-profile/{id}")
    public String loadPublicProfilePage(Model model, @PathVariable Long id,Principal principal) {
        User user = new User();
        User active;
        try {
            if(principal!=null) {
                active = userService.findByEmail(principal.getName());
                Collection<Role> roles = active.getRoles();
                List<Role> theList = new ArrayList<>(roles);
                if(theList.get(0).getName().equals("SERVICE_USER")) {
                    model.addAttribute("userType","sp");
                } else  {
                    model.addAttribute("userType","");
                }
                model.addAttribute("activeUsername",active.getFirstName()+' '+active.getLastName());
            }

            user = appService.getUserById(id);
        } catch (Exception e) {
            LOGGER.info("Something went wrong");
        }
        model.addAttribute("publicProfile",user);
        return "public-profile";
    }


    @PostMapping("/add-to-cart")
    public String addToCart(
            @RequestParam("id") String ids, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        User active;
        if(principal ==null) {
            return "redirect:/login";
        } else  {
            active = userService.findByEmail(principal.getName());
            Collection<Role> roles = active.getRoles();
            List<Role> theList = new ArrayList<>(roles);
            if(theList.get(0).getName().equals("SERVICE_USER")) {
                redirectAttributes.addFlashAttribute("userType","sp");
                model.addAttribute("userType","sp");
                return "redirect:/home";
            } else {
                model.addAttribute("userType","");
            }

            if(!active.getIsProfileCompleted()) {
                redirectAttributes.addFlashAttribute("msg","NA");
                return "redirect:/home";
            }
        }
        List<User> userTobeHire = new ArrayList<>();
        String[] usersIdsList = ids.split(",");
        Arrays.asList(usersIdsList).forEach(id -> {
            userTobeHire.add(appService.getUserById(Long.parseLong(id)));
        });
        model.addAttribute("userTobeHire",userTobeHire);
        model.addAttribute("activeUsername",active.getFirstName()+' '+active.getLastName());
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
            User me = userService.findByEmail(principal.getName());
            List<User> listOfHiredPeople = new ArrayList<>();
            List<Long> idsOfHiredUser = me.getListOfHiredPeople();
            idsOfHiredUser.forEach(id -> {
                 User user = appService.getUserById(id);
                 System.out.println("hired user --> "+user.toString());
                 listOfHiredPeople.add(user);
            });
            Collection<Role> roles = me.getRoles();
            List<Role> theList = new ArrayList<>(roles);
            if(theList.get(0).getName().equals("SERVICE_USER")) {
                model.addAttribute("userType","sp");
            } else  {
                model.addAttribute("userType","");
            }
            model.addAttribute("listOfHiredPeople",listOfHiredPeople);
            model.addAttribute("me",me);
            LOGGER.info("<<<<<Exiting from myOrderController");
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
            System.out.println("========>me =>"+user.toString());
            Collection<Role> roles = user.getRoles();
            List<Role> theList = new ArrayList<>(roles);
            if(theList.get(0).getName().equals("SERVICE_USER")) {
                model.addAttribute("userType","sp");
            } else  {
                model.addAttribute("userType","");
            }
            model.addAttribute("me",user);
            if(user.getConsumerId()!=null) {
                model.addAttribute("consumer",appService.getUserById(user.getConsumerId()));
            } else  {
                model.addAttribute("consumer",null);
            }

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from whoHireMeController catch");
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
            User user = appService.declineOrder(principal);
            LOGGER.info("<<<<<Exiting from declineController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from declineController");
            model.addAttribute("msg","Something went wrong !");
            return "redirect:/who-hire-me";
        }
        return "redirect:/who-hire-me";
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
            user.setHiredStartTime(LocalTime.now());
            userService.save(user);
            LOGGER.info("<<<<<Exiting from acceptController");
            model.addAttribute("me",user);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from acceptController catch");
            model.addAttribute("msg","Something went wrong !");
            return "redirect:/who-hire-me";
        }
        return "redirect:/who-hire-me";
    }

    @GetMapping("/cancel/{id}")
    public String cancelController(
            Model model,
            Principal principal, @PathVariable Long id) {
        LOGGER.info(">>>>>Entering into cancelController");
        try {
            User me = appService.cancelOrder(principal,id);
            LOGGER.info("user after cancel --->"+me);
            model.addAttribute("me", me);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from cancelController catch");
            model.addAttribute("msg", "Something went wrong !");
            return "redirect:/my-hiring";
        }
        return "redirect:/my-hiring";
    }
}
