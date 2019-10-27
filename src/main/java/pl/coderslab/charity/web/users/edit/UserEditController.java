package pl.coderslab.charity.web.users.edit;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.UserService;
import pl.coderslab.charity.web.users.UserFormDTO;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users/edit")
public class UserEditController {

    private UserService userService;

    public UserEditController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loggedUser")
    public User loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }


    @GetMapping
    public String editUserPage(Model model, Principal principal) {
        model.addAttribute("userFormDTO", new UserFormDTO(userService.getUserByEmail(principal.getName())));
        model.addAttribute("headerClass", "form");
        return "editUser";
    }

    @PostMapping
    public String editUserPage(@ModelAttribute("userFormDTO") @Valid UserFormDTO userFormDTO, BindingResult result, Model model) {
        model.addAttribute("headerClass", "form");
        if (result.hasErrors()) {
            return "editUser";
        }

        if (!userFormDTO.getPassword().equals(userFormDTO.getRePassword())) {
            result.rejectValue("rePassword", null,"Hasła muszą być zgodne");
            return "editUser";
        }

        userService.addUpdateUser(userFormDTO);
        return "redirect:/";
    }
}