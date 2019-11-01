package pl.coderslab.charity.web.users.register;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/register_process")
public class RegisterProcessController {

    private UserService userService;
    private Messages messages;

    public RegisterProcessController(UserService userService, Messages messages) {
        this.userService = userService;
        this.messages = messages;
    }

    @GetMapping
    public String resetPage(@RequestParam(required = false) String userUUID, @RequestParam(required = false) String userEmail,
                            Model model) {
        if (userEmail!=null) {
            if (userService.checkEmailUUID(userEmail,userUUID)) {
                userService.updateAvailable(userEmail,true);
                model.addAttribute("message",messages.get("registerPageProcess.controllerMsg.activeAccount"));
            }
        } else {
            model.addAttribute("message", messages.get("registerPageProcess.controllerMsg.email"));
        }
        return "registerProcess";
    }
}
