package pl.coderslab.charity.web.admin.users;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    private UserService userService;


    public AdminUsersController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loggedUser")
    public User loggedUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }

    @GetMapping
    public String institutionsMainPage(Model model) {
        model.addAttribute("headerClass", "form");

        model.addAttribute("users", userService.getAllUsersExceptPrincipal(loggedUser()));
        return "users";
    }


    @PostMapping
    public String institutionDelete(@RequestParam Long elementId, Model model) {
        userService.removeUserById(elementId);
        return "redirect:/admin/users";
    }

}
