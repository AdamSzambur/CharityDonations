package pl.coderslab.charity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.dto.MessageDTO;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.EmailService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private InstitutionService institutionService;
    private DonationService donationService;
    private EmailService emailService;
    private Messages messages;


    @ModelAttribute("sumOfQuantity")
    public Integer sumOfQuantity() {
        return donationService.getSumOfQuantity();
    }

    @ModelAttribute("sumDonatedInstitutions")
    public Integer sumDonatedInstitutions() {
        return donationService.sumAllDonatedInstitiutions();
    }

    @ModelAttribute("institutions")
    public List<InstitutionDTO> institutions() {
        return institutionService.getAllInstitutions();
    }

    public HomeController(InstitutionService institutionService, DonationService donationService, EmailService emailService, Messages messages) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.emailService = emailService;
        this.messages = messages;
    }

    @GetMapping
    public String homeAction(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("messageDTO", new MessageDTO(principal.getName()));
        } else {
            model.addAttribute("messageDTO", new MessageDTO("Anonymous"));
        }
        model.addAttribute("headerClass", "main");

        // Local values of form PlaceHolder attribute
        model.addAttribute("name", messages.get("mainPage.contactForm.name"));
        model.addAttribute("surname", messages.get("mainPage.contactForm.surname"));
        model.addAttribute("message", messages.get("mainPage.contactForm.message"));
        return "index";
    }


    @PostMapping
    public String sendEmail(@ModelAttribute("messageDTO") @Valid MessageDTO messageDTO, BindingResult result, Model model) {
        System.out.println(messageDTO);

        if (result.hasErrors()) {
            model.addAttribute("headerClass", "main");
            return "index";
        }

        emailService.sendMessage(messageDTO);
        model.addAttribute("headerClass", "form");
        return "formConfirmation";
    }
}
