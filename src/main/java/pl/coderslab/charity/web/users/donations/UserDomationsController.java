package pl.coderslab.charity.web.users.donations;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users/donations")
public class UserDomationsController {

    private DonationService donationService;
    private UserService userService;

    public UserDomationsController(DonationService donationService, UserService userService) {
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping
    public String userDonationsPage(Model model, Principal principal) {
        model.addAttribute("donations", donationService.getAllDonationsByUser(userService.getUserByEmail(principal.getName()).getId()));
        model.addAttribute("formater", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "donationsUser";
    }
}
