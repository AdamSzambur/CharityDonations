package pl.coderslab.charity.web.users.resetPassword;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.EmailService;
import pl.coderslab.charity.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/users/reset_password_process")
public class ResetPasswordProcessController {


    private UserService userService;
    private Messages messages;


    public ResetPasswordProcessController(UserService userService, Messages messages) {
        this.userService = userService;
        this.messages = messages;
    }

    @GetMapping
    public String registerUserPage(@RequestParam(required = false) String userUUID, @RequestParam(required = false) String userEmail,
                                   Model model) {
        if ((userEmail!=null) && (userUUID!=null)) {
            if (userService.checkEmailUUID(userEmail,userUUID)) {
                model.addAttribute("userDTO", userService.getUserByEmail(userEmail));
            }
        }
        return "resetPasswordProcess";
    }

    @PostMapping
    public String registerUserPage(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "resetPasswordProcess";
        }

        if (!userDTO.getPassword().equals(userDTO.getRePassword())) {
            result.rejectValue("rePassword", null, messages.get("registerPage.controllerMsg.wrongPassword"));
            return "resetPasswordProcess";
        }

        userService.addUpdateUser(userDTO);
        return "redirect:/";
    }
}
