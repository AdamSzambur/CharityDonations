package pl.coderslab.charity.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.dto.UserDTO;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private DonationService donationService;

    private ModelMapper mapper = new ModelMapper();
    private Type targetListUserDTO = new TypeToken<List<UserDTO>>() {}.getType();

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

    public void addUpdateUser(UserDTO userFormDTO) {
        User user = mapper.map(userFormDTO,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user!=null) return mapper.map(userRepository.findByEmail(email),UserDTO.class);
        return null;
    }

    public UserDTO getUserById(long userId) {
        return mapper.map(userRepository.getOne(userId),UserDTO.class);
    }

    public List<UserDTO> getAllUsersExceptPrincipal() {
        List<UserDTO> result = mapper.map(userRepository.findAll(),targetListUserDTO);
        result.remove(mapper.map(userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()),UserDTO.class));
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
        List<DonationDTO> donationList = donationService.getAllDonationsByUser(user.getId());
        donationList.forEach(d->donationService.delete(d.getId()));
        userRepository.delete(userRepository.getOne(elementId));
    }
}
