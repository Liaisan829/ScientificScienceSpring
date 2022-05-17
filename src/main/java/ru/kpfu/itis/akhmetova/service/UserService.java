package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.SignUpForm;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void signUp(SignUpForm form);
    Optional<User> getUserByEmail(String email);
    void update(UserDto userDto, String email);
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto userDto);
    UserDto getUserById(Integer userId);
}
