package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserDTO {

    private Long id;

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

    private String fullName;

    private UUID uuid;

    public UserDTO() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    public UserDTO(String role, Boolean available) {
        setRole(role);
        setAvailable(available);
    }


}
