package pl.coderslab.charity.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.models.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDTO {

    private Long id;

    private User user;

    @NotNull(message = "{validator.notNull")
    private List<Category> categories;

    @NotNull(message = "{validator.notNull")
    private Integer quantity;

    @NotNull(message = "{validator.notNull")
    private Institution institution;

    @NotBlank(message = "{validator.notBlank")
    private String street;

    @NotBlank(message = "{validator.notBlank")
    private String city;

    @NotBlank(message = "{validator.notBlank")
    private String zipCode;

    @NotBlank(message = "{validator.notBlank")
    private String phone;

    private String status;

    private LocalDateTime created;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull(message = "{validator.notNull")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate plannedPickUpDate;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;

    public DonationDTO() {
    }
}
