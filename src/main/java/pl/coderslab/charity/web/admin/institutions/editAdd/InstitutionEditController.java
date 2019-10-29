package pl.coderslab.charity.web.admin.institutions.editAdd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/institutions/editAdd")
public class InstitutionEditController {

    private InstitutionService institutionService;


    public InstitutionEditController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String institutionEditMainPage(@RequestParam(required = false) Long institutionId, Model model) {
        model.addAttribute("headerClass", "form");
        if (institutionId != null) {
            model.addAttribute("institutionDTO", institutionService.getInstitutionById(institutionId));
            model.addAttribute("title", "Szczegóły instytucji");
        } else {
            model.addAttribute("institutionDTO", new InstitutionDTO());
            model.addAttribute("title", "Dodaj nową instytucję");
        }
        return "institution";
    }

    @PostMapping
    public String processEditMainPage(@ModelAttribute("institutionDTO") @Valid InstitutionDTO institutionDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("headerClass", "form");
            if (institutionDTO.getId() != null) {
                model.addAttribute("title", "Szczegóły instytucji");
            } else {
                model.addAttribute("title", "Dodaj nową instytucję");
            }
            return "institution";
        }
        institutionService.addUpdateInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }

}
