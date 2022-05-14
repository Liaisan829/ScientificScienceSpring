package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

//    @Value("${server.port}")
//    String userDto;

    @Override
    public void signUp(SignUpForm form) {
        User newUser = User.builder()
                .name(form.getName())
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .confirmCode(UUID.randomUUID().toString())
                .state(User.State.CONFIRMED)
                .role(User.Role.USER)
                .build();

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
