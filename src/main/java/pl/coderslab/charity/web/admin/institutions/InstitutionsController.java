package pl.coderslab.charity.web.admin.institutions;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin/institutions")
public class InstitutionsController {

    private UserService userService;
    private InstitutionService institutionService;


    public InstitutionsController(UserService userService, InstitutionService institutionService) {
        this.userService = userService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("loggedUser")
    public User loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public String institutionsMainPage(Model model) {
        model.addAttribute("headerClass", "form");
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "institutions";
    }


    @PostMapping
    public String institutionDelete(@RequestParam Long elementId, Model model) {
        institutionService.removeInstitutionById(elementId);
        return "redirect:/admin/institutions";
    }

}
