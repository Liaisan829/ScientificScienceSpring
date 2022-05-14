package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.SignUpForm;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.Optional;

public interface UserService {
    void signUp(SignUpForm form);
    Optional<User> getUserByEmail(String email);
}
