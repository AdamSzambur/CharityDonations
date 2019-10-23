package pl.coderslab.charity.web.donations;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDTO {

    private List<Category> categories;

    private Integer quantity;

    private Institution institution;

    private String street;

    private String city;

    private String zipCode;

    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
