package pl.coderslab.charity.web.admin.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.services.UserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    private UserService userService;

    public AdminUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String institutionsMainPage(Model model) {
        model.addAttribute("users", userService.getAllUsersExceptPrincipal());
        return "users";
    }

    @PostMapping
    public String institutionDelete(@RequestParam Long elementId, Model model) {
        userService.removeUserById(elementId);
        return "redirect:/admin/users";
    }

}
