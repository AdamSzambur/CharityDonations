package pl.coderslab.charity.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.User;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.UserService;

@Component
public class UserConverter implements Converter<String, UserDTO> {
    @Autowired
    private UserService userService;

    @Override
    public UserDTO convert(String s) {
        return userService.getUserById(Long.parseLong(s), UserDTO.class);
    }
}
