package pl.coderslab.charity.web.users.register;


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

@Controller
@RequestMapping("/users/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registerUserPage(Model model) {
        model.addAttribute("userFormDTO", new UserDTO("ROLE_USER", true));
        return "register";
    }

    @PostMapping
    public String registerUserPage(@ModelAttribute("userFormDTO") @Valid UserDTO userFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        if (!userFormDTO.getPassword().equals(userFormDTO.getRePassword())) {
            result.rejectValue("rePassword", null, "Hasła muszą być zgodne");
            return "register";
        }

        if (!userService.isEmailAvailable(userFormDTO.getEmail())) {
            result.rejectValue("email", null, "Email jest zajęty");
            return "register";
        }

        userService.addUpdateUser(userFormDTO);
        return "redirect:/";
    }
}
