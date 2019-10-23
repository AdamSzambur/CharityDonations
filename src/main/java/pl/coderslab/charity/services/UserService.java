package pl.coderslab.charity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.web.users.UserFormDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUpdateUser(UserFormDTO userFormDTO) {
        User user = new User();
        user.setEmail(userFormDTO.getEmail());
        user.setFirstName(userFormDTO.getFirstName());
        user.setLastName(userFormDTO.getLastName());
        user.setPassword(passwordEncoder.encode(userFormDTO.getPassword()));
        userRepository.save(user);
    }
}