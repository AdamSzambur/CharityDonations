package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class InstitutionDTO {

    private Long id;

    @NotBlank(message = "{validator.notBlank")
    private String name;

    private String description;

    public InstitutionDTO() {

    }
}
