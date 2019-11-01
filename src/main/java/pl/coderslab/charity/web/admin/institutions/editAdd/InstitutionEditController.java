package pl.coderslab.charity.web.admin.institutions.editAdd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/institutions/editAdd")
public class InstitutionEditController {

    private InstitutionService institutionService;
    private Messages messages;


    public InstitutionEditController(InstitutionService institutionService, Messages messages) {
        this.institutionService = institutionService;
        this.messages = messages;
    }

    @GetMapping
    public String institutionEditMainPage(@RequestParam(required = false) Long institutionId, Model model) {
        if (institutionId != null) {
            model.addAttribute("institutionDTO", institutionService.getInstitutionById(institutionId));
            model.addAttribute("title", messages.get("institutionEditPage.controllerMsg.details"));
        } else {
            model.addAttribute("institutionDTO", new InstitutionDTO());
            model.addAttribute("title", messages.get("institutionEditPage.controllerMsg.new"));
        }
        return "institution";
    }

    @PostMapping
    public String processEditMainPage(@ModelAttribute("institutionDTO") @Valid InstitutionDTO institutionDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            if (institutionDTO.getId() != null) {
                model.addAttribute("title", messages.get("institutionEditPage.controllerMsg.details"));
            } else {
                model.addAttribute("title", messages.get("institutionEditPage.controllerMsg.new"));
            }
            return "institution";
        }
        institutionService.addUpdateInstitution(institutionDTO);
        return "redirect:/admin/institutions";
    }

}
