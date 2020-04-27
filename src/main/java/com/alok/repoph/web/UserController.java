package com.alok.repoph.web;

import com.alok.repoph.models.User;
import com.alok.repoph.pojo.About;
import com.alok.repoph.pojo.Address;
import com.alok.repoph.pojo.NationalId;
import com.alok.repoph.pojo.Skill;
import com.alok.repoph.services.UserServiceImpl;
import com.alok.repoph.web.dto.AboutDto;
import com.alok.repoph.web.dto.ContactDto;
import com.alok.repoph.web.dto.UserLoginDto;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceImpl userService;

    @ModelAttribute("loginForm")
    public UserLoginDto loginDto() {
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String loadLogInForm(@ModelAttribute("msg") String message,Principal principal,Model model) {
        if (principal != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("msg",message);
            return "user-login";
        }
    }

    @RequestMapping("/login-error")
    public String loadLogInFormWithError(Principal principal, Model model) {
        if (principal != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("msg","Incorrect username or password");
            return "user-login";
        }
    }

    @ModelAttribute("registrationForm")
    public UserRegistrationDto forgotPasswordDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String loadRegisterForm(Principal principal) {
        if(principal!=null) {
            return "redirect:/profile";
        }
        return "user-registration";
    }

    @PostMapping("/registration")
    public String registerEndUser(
            @ModelAttribute("registrationForm") @Valid UserRegistrationDto form,
            BindingResult result,
            Model model,
            @RequestParam( defaultValue = "false", required = false, name ="serviceOrEnd") Boolean role,
            @RequestParam( defaultValue = "false", required = false, name ="gender") Boolean gender,
            RedirectAttributes redirectAttributes) {
        form.setRole(role);
        form.setGender(gender);
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
        redirectAttributes.addFlashAttribute("msg" ,message);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String loadProfile(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            model.addAttribute("profile",userService.findByEmail(principal.getName()));
        }
        return "profile";
    }

    @GetMapping("/update-address")
    public String loadUpdateAddressForm(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            Address address = userService.findByEmail(principal.getName()).getAddress();
            if(address==null) {
                model.addAttribute("addressFrom",new Address());
            } else  {
                model.addAttribute("addressFrom",address);
            }

        }
        return "update-address";
    }

    @PostMapping("/update-address")
    public String updateAddressController(
            @ModelAttribute("addressFrom") @Valid Address form,
            BindingResult result,
            Principal principal,
            Model model) {
        LOGGER.info(">>>>>Entering into updateAddressController ");
        String message;
        try {
            message= userService.updateAddress(form,principal);
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg",message);

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from registerController");
            model.addAttribute("msg","Something went wrong !");
            return "update-address";
        }
        return "update-address";
    }

    @GetMapping("/update-contact")
    public String loadUpdateContactForm(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            User user = userService.findByEmail(principal.getName());
            ContactDto contact;
            if(user.getMobileNumber()==null) {
                contact = new ContactDto(user.getEmail(),"");
            } else  {
                contact = new ContactDto(user.getEmail(),user.getMobileNumber());
            }
            model.addAttribute("contactFrom",contact);

        }
        return "update-contact";
    }

    @PostMapping("/update-contact")
    public String updateContactController(
            @ModelAttribute("contactFrom") @Valid ContactDto form,
            BindingResult result,
            Principal principal,
            Model model) {
        LOGGER.info(">>>>>Entering into updateContactController ");
        String message;
        try {
            message= userService.updateContact(form,principal);
            LOGGER.info("<<<<<Exiting from updateContactController");
            model.addAttribute("msg",message);

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateContactController");
            model.addAttribute("msg","Something went wrong !");
            return "update-contact";
        }
        return "update-contact";
    }

    @GetMapping("/update-national-id")
    public String loadUpdateNationalIdForm(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            NationalId nationalId = userService.findByEmail(principal.getName()).getNationalId();
            if(nationalId==null) {
                nationalId = new NationalId();
            }
            model.addAttribute("nationalIdFrom",nationalId);

        }
        return "update-national-id";
    }

    @PostMapping("/update-national-id")
    public String updateNationalIdController(
            @ModelAttribute("nationalIdFrom") @Valid NationalId form,
            BindingResult result,
            Principal principal,
            Model model) {
        LOGGER.info(">>>>>Entering into updateNationalIdController ");
        String message;
        try {
            message= userService.updateNationalId(form,principal);
            LOGGER.info("<<<<<Exiting from updateNationalIdController");
            model.addAttribute("msg",message);

        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateNationalIdController");
            model.addAttribute("msg","Something went wrong !");
            return "update-national-id";
        }
        return "update-national-id";
    }

    @GetMapping("/update-skills-pricing")
    public String loadUpdateSkillsForm(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            List<Skill> skills = userService.findByEmail(principal.getName()).getSkills();
            if(skills==null) {
                skills = new ArrayList<>();
            }
            model.addAttribute("skills",skills);

        }
        return "update-skills-pricing";
    }

    @PostMapping("/update-skills-pricing")
    public String updateSkillsAndPricingController(
            @RequestParam("name") String name,
            @RequestParam("exp") String exp,
            @RequestParam("pricing") Double pricing,
            Principal principal,
            RedirectAttributes redirectAttributes,
            Model model) {
        LOGGER.info(">>>>>Entering into updateSkillsController ");
        String nameList[] = name.split(",");
        String expList[] = exp.split(",");

        List<Skill> skillList = new ArrayList<>();

        for (int i = 0; i < nameList.length; i++) {
            Skill skill = new Skill();
            skill.setSkillName(nameList[i]);
            skill.setExperience((Integer.parseInt(expList[i])));
            skillList.add(skill);
        }
        String message;
        try {
            message= userService.updateSkillsAndPricing(skillList,pricing,principal);
            LOGGER.info("<<<<<Exiting from updateSkillsController");
            redirectAttributes.addFlashAttribute("msg", message);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateSkillsController");
            model.addAttribute("msg","Something went wrong !");
            return "update-skills-pricing";
        }
        return "redirect:/update-skills-pricing";
    }

    @GetMapping("/update-role")
    public String loadUpdateRole(Principal principal) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            return "update-role";
        }
    }

    @PostMapping("/update-role")
    public String updateRoleController(
            Principal principal,
            Model model,
            @RequestParam( defaultValue = "false", required = false, name ="serviceOrEnd") Boolean role,
            RedirectAttributes redirectAttributes) {
        LOGGER.info(">>>>>Entering into updateRoleController");
        String message;
        try {
            message= userService.updateRole(role,principal);
            LOGGER.info("<<<<<Exiting from updateRoleController");
            model.addAttribute("msg",message);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateRoleController");
            model.addAttribute("msg","Something went wrong !");
            return "update-role";
        }
        redirectAttributes.addFlashAttribute("msg" ,message);
        return "update-role";
    }

    @GetMapping("/update-about")
    public String loadUpdateAbout(Principal principal,Model model) {
        if(principal==null) {
            return "redirect:/login";
        } else  {
            About about = userService.findByEmail(principal.getName()).getAbout();
            if(about==null) {
                about = new About();
            }
            model.addAttribute("aboutForm",about);

        }
        return "update-about";
    }

    @PostMapping("/update-about")
    public String updateAboutController(
            Principal principal,
            Model model,
            @ModelAttribute("aboutForm") @Valid AboutDto form,
            RedirectAttributes redirectAttributes) {
        LOGGER.info(">>>>>Entering into updateAboutController");
        String message;
        try {
            message= userService.updateAbout(form,principal);
            LOGGER.info("<<<<<Exiting from updateAboutController");
            model.addAttribute("msg",message);
        } catch (Exception e) {
            LOGGER.info("<<<<<Exiting from updateAboutController");
            model.addAttribute("msg","Something went wrong !");
            return "update-about";
        }
        redirectAttributes.addFlashAttribute("msg" ,message);
        return "update-about";
    }
}
