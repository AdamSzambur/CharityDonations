package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long categoryId) {
        return categoryRepository.getOne(categoryId);
    }
}
