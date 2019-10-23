package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.InstitutionService;

@Component
public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.getCategoryById(Long.parseLong(s));
    }
}
