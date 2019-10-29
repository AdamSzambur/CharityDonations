package pl.coderslab.charity.web.users.donations.details;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.services.DonationService;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users/donations/details")
public class DonationDetailsController {

    private DonationService donationService;


    public DonationDetailsController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping
    public String userDonationsPage(@RequestParam Long donationId, Model model) {
        model.addAttribute("donation", donationService.getDonationById(donationId));
        model.addAttribute("formater", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        model.addAttribute("headerClass", "form");
        return "donation";
    }

    @PostMapping
    public String donationChangeStatus(@RequestParam Long elementId, Model model) {
        System.out.println(elementId);
        donationService.changeStatusToReceived(elementId);
        return "redirect:/users/donations/details?donationId=" + elementId;
    }
}
