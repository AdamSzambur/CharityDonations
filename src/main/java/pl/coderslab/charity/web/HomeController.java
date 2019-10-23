package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {

    InstitutionService institutionService;
    DonationService donationService;


    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("sumOfQuantity", donationService.getSumOfQuantity());
        model.addAttribute("sumDonatedInstitutions", donationService.sumAllDonatedInstitiutions());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "index";
    }
}
