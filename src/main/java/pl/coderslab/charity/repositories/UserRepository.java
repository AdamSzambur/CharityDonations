package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    long countByEmail(String email);
}
