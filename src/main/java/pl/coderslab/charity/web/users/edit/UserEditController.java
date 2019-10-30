package pl.coderslab.charity.web.users.edit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.UserService;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users/edit")
public class UserEditController {

    private UserService userService;

    public UserEditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String editUserPage(Model model, Principal principal) {
        model.addAttribute("userFormDTO", userService.getUserByEmail(principal.getName()));
        return "editUser";
    }

    @PostMapping
    public String editUserPage(@ModelAttribute("userFormDTO") @Valid UserDTO userFormDTO, BindingResult result, Model model) {
        model.addAttribute("headerClass", "form");
        if (result.hasErrors()) {
            return "editUser";
        }

        if (!userFormDTO.getPassword().equals(userFormDTO.getRePassword())) {
            result.rejectValue("rePassword", null, "Hasła muszą być takie same");
            return "editUser";
        }

        userService.addUpdateUser(userFormDTO);
        return "redirect:/";
    }
}
