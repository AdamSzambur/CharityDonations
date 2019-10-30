package pl.coderslab.charity.web.admin.users.edit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.dto.UserSimpleDTO;
import pl.coderslab.charity.services.UserService;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/users/edit")
public class AdminUsersEditController {

    private UserService userService;

    public AdminUsersEditController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("roles")
    public List<String> roles() {
        String[] result = {"ROLE_ADMIN", "ROLE_USER"};
        return Arrays.asList(result);
    }

    @GetMapping
    public String institutionsMainPage(@RequestParam Long userId, Model model) {
        model.addAttribute("userDTO", userService.getUserById(userId, UserSimpleDTO.class));
        return "user";
    }


    @PostMapping
    public String institutionDelete(@ModelAttribute("userDTO") @Valid UserSimpleDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user";
        }
        userService.updateRoleAndAvailable(userDTO);

        return "redirect:/admin/users";
    }

}
