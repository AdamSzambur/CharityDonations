package pl.coderslab.charity.web.admin.institutions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.services.InstitutionService;

@Controller
@RequestMapping("/admin/institutions")
public class InstitutionsController {

    private InstitutionService institutionService;


    public InstitutionsController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String institutionsMainPage(Model model) {
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "institutions";
    }


    @PostMapping
    public String institutionDelete(@RequestParam Long elementId, Model model) {
        institutionService.removeInstitutionById(elementId);
        return "redirect:/admin/institutions";
    }

}
