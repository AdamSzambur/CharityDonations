package pl.coderslab.charity.web.donations;

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
public class DonationDTO {

    private User user;

    @NotNull
    private List<Category> categories;

    @NotNull
    private Integer quantity;

    @NotNull
    private Institution institution;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String phone;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate plannedPickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

    public DonationDTO(User user) {
        this.user = user;
    }

    public DonationDTO() {
    }
}
