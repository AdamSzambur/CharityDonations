package pl.coderslab.charity.web.users.donations;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users/donations")
public class UserDomationsController {


    private UserService userService;
    private DonationService donationService;


    public UserDomationsController(UserService userService, DonationService donationService) {
        this.userService = userService;
        this.donationService = donationService;
    }

    @ModelAttribute("loggedUser")
    public UserDTO loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public String userDonationsPage(Model model) {
        model.addAttribute("donations", donationService.getAllDonationsByUser(loggedUser().getId()));
        model.addAttribute("formater", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        model.addAttribute("headerClass", "form");
        return "donationsUser";
    }
}
