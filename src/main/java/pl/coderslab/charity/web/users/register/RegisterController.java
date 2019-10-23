package pl.coderslab.charity.web.users.register;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.UserService;
import pl.coderslab.charity.web.users.UserFormDTO;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerUserPage(Model model) {
        model.addAttribute("userFormDTO", new UserFormDTO());
        return "register";
    }

    @PostMapping
    public String registerUserPage(@ModelAttribute("userFormDTO") @Valid UserFormDTO userFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.addUpdateUser(userFormDTO);
        return "redirect:";
    }
}
