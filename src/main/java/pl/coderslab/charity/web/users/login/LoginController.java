package pl.coderslab.charity.web.users.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.LoginFormDTO;

import java.security.Principal;

@Controller
@RequestMapping("/users/login")
public class LoginController {

    @GetMapping
    public String loginPage(@RequestParam(required = false) String error, Model model, Principal principal) {
        if (principal==null) {
            model.addAttribute("loginUserDTO", new LoginFormDTO());
            if (!(error == null)) {
                model.addAttribute("errorMsg", "Podano błędne dane logowania");
            }
            return "login";
        }
        return "redirect:/";
    }
}
