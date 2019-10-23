package pl.coderslab.charity.web.donations;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/donations")
public class DonationControler {

    private DonationService donationService;
    private CategoryService categoryService;
    private InstitutionService institutionService;

    public DonationControler(DonationService donationService, CategoryService categoryService, InstitutionService institutionService) {
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("categories")
    public List<Category> categories () {
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions () {
        return institutionService.getAllCategories();
    }

    @GetMapping
    public String donationMainPage(Model model){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("actualDate", LocalDate.now().format(inputFormatter));
        model.addAttribute("donation", new DonationDTO());
        return "donation";
    }

    @PostMapping
    public String proccessDonationMainPage(@ModelAttribute("donation") @Valid DonationDTO donation, BindingResult result) {
        if (result.hasErrors()) {
            return "donation";
        }


        donationService.addDonation(donation);

        System.out.println(donation);
        return "redirect:";
    }

}
