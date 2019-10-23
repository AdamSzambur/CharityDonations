package pl.coderslab.charity.web.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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


    public UserFormDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
