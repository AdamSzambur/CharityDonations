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
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void addUpdateUser(UserFormDTO userFormDTO) {
        User user = userRepository.findByEmail(userFormDTO.getEmail());
        if (user==null) user = new User();
        user.setEmail(userFormDTO.getEmail());
        user.setFirstName(userFormDTO.getFirstName());
        user.setLastName(userFormDTO.getLastName());
        user.setPassword(passwordEncoder.encode(userFormDTO.getPassword()));
        user.setRole(userFormDTO.getRole());
        user.setAvailable(userFormDTO.getAvailable());
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(long userId) {
        return userRepository.getOne(userId);
    }
}
