package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.InstitutionService;

@Component
public class CategoryDTOConverter implements Converter<String, CategoryDTO> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDTO convert(String s) {
        return categoryService.getCategoryById(Long.parseLong(s));
    }
}
