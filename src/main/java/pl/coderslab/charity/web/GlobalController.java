package pl.coderslab.charity.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;

@ControllerAdvice
public class GlobalController {

    private UserService userService;

    public GlobalController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loggedUser")
    public UserDTO loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }

    @ModelAttribute("headerClass")
    public String headerClass() {
        return "form";
    }
}
