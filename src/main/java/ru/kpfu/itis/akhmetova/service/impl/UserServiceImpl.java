package ru.kpfu.itis.akhmetova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.SignUpForm;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.UserService;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    @Value("${server.port}")
//    String userDto;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(SignUpForm form) {
        User newUser = new User(
                form.getEmail(),
                passwordEncoder.encode(form.getPassword()),
                form.getName(),
                UUID.randomUUID().toString(),
                User.Role.USER,
                User.State.NOT_CONFIRMED
                );
        userRepository.save(newUser);

//        TODO
//        HashMap<String, String> data = new HashMap<>();
//        data.put("confirm_code", newUser.getConfirmCode());
//        data.put("first_name", newUser.getName());
//        data.put("port", userDto);
//        emailUtil.sendMail(newUser.getEmail(), "confirm", "mails/confirm_mail.ftlh",
//                data);
//    }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
