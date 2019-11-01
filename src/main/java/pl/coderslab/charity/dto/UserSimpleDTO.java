package pl.coderslab.charity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserSimpleDTO {

    private Long id;

    @NotBlank(message = "{validator.notBlank")
    @Email(message = "{validator.email")
    private String email;

    @NotBlank(message = "{validator.notBlank")
    private String firstName;

    @NotBlank(message = "{validator.notBlank")
    private String lastName;

    @NotBlank(message = "{validator.notBlank")
    private String role;

    private Boolean available;

    private String fullName;

    private UUID uuid;

    public UserSimpleDTO() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    public UserSimpleDTO(String role, Boolean available) {
        setRole(role);
        setAvailable(available);
    }


}
