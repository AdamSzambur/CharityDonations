package pl.coderslab.charity.web.admin.institutions.editAdd;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin/institutions/editAdd")
public class InstitutionEditController {

    private UserService userService;
    private InstitutionService institutionService;


    public InstitutionEditController(UserService userService, InstitutionService institutionService) {
        this.userService = userService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("loggedUser")
    public UserDTO loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public String institutionEditMainPage(@RequestParam(required = false) Long institutionId, Model model) {
        model.addAttribute("headerClass", "form");
        if (institutionId!=null) {
            model.addAttribute("institutionDTO", institutionService.getInstitutionById(institutionId));
            model.addAttribute("title","Szczegóły instytucji");
        } else {
            model.addAttribute("institutionDTO", new InstitutionDTO());
            model.addAttribute("title","Dodaj nową instytucję");
        }
        return "institution";
    }

    @PostMapping
    public String processEditMainPage(@ModelAttribute("institutionDTO") @Valid InstitutionDTO institutionDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("headerClass", "form");
            if (institutionDTO.getId()!=null) {
                model.addAttribute("title","Szczegóły instytucji");
            } else {
                model.addAttribute("title","Dodaj nową instytucję");
            }
            return "institution";
        }
        institutionService.addUpdateInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }

}
