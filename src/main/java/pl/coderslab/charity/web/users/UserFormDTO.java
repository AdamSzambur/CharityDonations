package pl.coderslab.charity.web.users;

import lombok.Data;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserFormDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 12)
    private String password;

    @NotBlank
    @Size(min = 8, max = 12)
    private String rePassword;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String role;

    private Boolean available;



    public UserFormDTO() {
    }

    public UserFormDTO(String role, Boolean available) {
        setRole(role);
        setAvailable(available);
    }

    public UserFormDTO(User user) {
        setRole(user.getRole());
        setAvailable(user.getAvailable());
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName((user.getLastName()));
    }
}
