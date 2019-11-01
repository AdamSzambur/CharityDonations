package pl.coderslab.charity.web.users.resetPassword;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.LoginFormDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.EmailService;
import pl.coderslab.charity.services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/users/reset_password")
public class ResetPasswordController {


    private UserService userService;
    private EmailService emailService;
    private Messages messages;


    public ResetPasswordController(UserService userService, EmailService emailService, Messages messages) {
        this.userService = userService;
        this.emailService = emailService;
        this.messages = messages;
    }

    @GetMapping
    public String resetPage(Model model) {
        return "resetPassword";
    }

    @PostMapping
    public String resetPasswordProcess(@RequestParam String email, Model model, HttpServletRequest servletRequest) {
        UserDTO user = userService.getUserByEmail(email);

        String serverAddress = servletRequest.getRequestURL().substring(0,servletRequest.getRequestURL().length()-servletRequest.getRequestURI().length())+servletRequest.getServletContext().getContextPath();

        if (user != null) {
            // sending email
            emailService.sendResetPassword(email, serverAddress);
            model.addAttribute("message", messages.get("resetPassword.controllerMsg.email")+" "+email);
        } else {
            model.addAttribute("error", messages.get("resetPassword.controllerMsg.noEmail"));
        }

        return "resetPassword";
    }
}
