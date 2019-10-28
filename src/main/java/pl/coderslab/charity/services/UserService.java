package pl.coderslab.charity.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Donation;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.web.admin.users.edit.UserDTO;
import pl.coderslab.charity.web.users.UserFormDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private DonationService donationService;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, DonationService donationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.donationService = donationService;
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

    public List<User> getAllUsersExceptPrincipal(User user) {
        List<User> result = userRepository.findAll();
        result.remove(user);
        return result;
    }

    public void updateRoleAndAvailable(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        user.setAvailable(userDTO.getAvailable());
        user.setRole(userDTO.getRole());
        userRepository.save(user);
    }

    public void removeUserById(Long elementId) {
        User user = userRepository.getOne(elementId);
        List<Donation> donationList = donationService.getAllDonationsByUser(user.getId());
        donationList.forEach(d->donationService.delete(d));
        userRepository.delete(userRepository.getOne(elementId));
    }
}
