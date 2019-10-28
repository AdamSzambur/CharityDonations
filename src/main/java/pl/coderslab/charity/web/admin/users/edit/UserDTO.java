package pl.coderslab.charity.web.admin.users.edit;

import lombok.Data;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String role;

    private Boolean available;

    public UserDTO() {
    }

    public UserDTO(User user) {
        setId(user.getId());
        setRole(user.getRole());
        setAvailable(user.getAvailable());
        setEmail(user.getEmail());
        setFirstName(user.getFirstName());
        setLastName((user.getLastName()));
    }
}
