package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.models.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
