package pl.coderslab.charity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Data
public class MessageDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String message;

    private String email;

    public MessageDTO(String email) {
        this.email = email;
    }

    public MessageDTO() {
    }
}
