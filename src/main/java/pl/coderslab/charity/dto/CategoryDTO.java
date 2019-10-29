package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.models.AbstractEntity;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryDTO extends AbstractEntity{


    private Long id;

    @NotBlank
    private String name;
}
