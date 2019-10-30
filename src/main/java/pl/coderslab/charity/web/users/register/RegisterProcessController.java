package pl.coderslab.charity.web.users.register;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/register_process")
public class RegisterProcessController {

    private UserService userService;

    public RegisterProcessController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String resetPage(@RequestParam(required = false) String userUUID, @RequestParam(required = false) String userEmail,
                            Model model) {

        if ((userUUID==null)&&(userEmail==null)) {
            model.addAttribute("message", "Wysłano na podany email link do aktywacji konta");
        } else if (userService.checkEmailUUID(userEmail,userUUID)){
            model.addAttribute("message","Link nie jest już aktywny");
        } else {
            userService.updateAvailable(userEmail,true);
            model.addAttribute("message","Konto zostało aktywowane");
        }
        return "resetPasswordProcess";
    }
}