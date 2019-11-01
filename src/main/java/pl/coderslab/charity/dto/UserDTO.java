package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.charity.Messages;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "{validator.notBlank}")
    @Email(message = "{validator.email}")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,12}$", message = "{validator.password}")
    private String password;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,12}$", message = "{validator.password}")
    private String rePassword;

    @NotBlank(message = "{validator.notBlank}")
    private String firstName;

    @NotBlank(message = "{validator.notBlank}")
    private String lastName;

    @NotBlank(message = "{validator.notBlank}")
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
