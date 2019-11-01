package pl.coderslab.charity.web.users.register;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.EmailService;
import pl.coderslab.charity.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import javax.validation.Valid;

@Controller
@RequestMapping("/users/register")
public class RegisterController {

    private UserService userService;
    private EmailService emailService;
    private Messages messages;


    public RegisterController(UserService userService, EmailService emailService, Messages messages) {
        this.userService = userService;
        this.emailService = emailService;
        this.messages = messages;
    }

    @GetMapping
    public String registerUserPage(Model model) {
        model.addAttribute("userFormDTO", new UserDTO("ROLE_USER", false));
        return "register";
    }

    @PostMapping
    public String registerUserPage(@ModelAttribute("userFormDTO") @Valid UserDTO userFormDTO, BindingResult result, HttpServletRequest servletRequest) {
        if (result.hasErrors()) {
            return "register";
        }

        if (!userFormDTO.getPassword().equals(userFormDTO.getRePassword())) {

            result.rejectValue("rePassword", null, messages.get("registerPage.controllerMsg.wrongPassword"));
            return "register";
        }

        if (!userService.isEmailAvailable(userFormDTO.getEmail())) {
            result.rejectValue("email", null, messages.get("registerPage.controllerMsg.emailNotAvailable"));
            return "register";
        }
//        System.out.println("URL : "+servletRequest.getRequestURL());
//        System.out.println("URI : "+servletRequest.getRequestURI());
//        System.out.println("ContextPath "+ servletRequest.getServletContext().getContextPath());


        String serverAddress = servletRequest.getRequestURL().substring(0,servletRequest.getRequestURL().length()-servletRequest.getRequestURI().length())+servletRequest.getServletContext().getContextPath();
        userService.addUpdateUser(userFormDTO);
        emailService.sendActiveUser(userFormDTO.getEmail(),serverAddress);

        return "redirect:/users/register_process";
    }
}
