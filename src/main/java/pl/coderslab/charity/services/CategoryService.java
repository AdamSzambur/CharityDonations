package pl.coderslab.charity.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper mapper = new ModelMapper();
    private Type targetListType = new TypeToken<List<CategoryDTO>>() {}.getType();

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategories() {
        return mapper.map(categoryRepository.findAll(), targetListType);
    }

    public CategoryDTO getCategoryById(long categoryId) {
        return mapper.map(categoryRepository.getOne(categoryId), CategoryDTO.class);
    }
}
