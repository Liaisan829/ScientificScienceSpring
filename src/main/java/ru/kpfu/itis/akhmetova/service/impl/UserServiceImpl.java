package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.SignUpForm;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.helper.AccountNotExistsException;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.UserService;
import ru.kpfu.itis.akhmetova.utils.EmailUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.kpfu.itis.akhmetova.dto.UserDto.fromModel;
import static ru.kpfu.itis.akhmetova.dto.UserDto.fromModelList;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${server.port}")
    String userDto;

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

        HashMap<String, String> data = new HashMap<>();
        data.put("confirm_code", newUser.getConfirmCode());
        data.put("first_name", newUser.getName());
        data.put("port", userDto);
        emailUtil.sendMail(newUser.getEmail(), "confirm", "mails/confirm_mail.ftlh",
                data);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void update(UserDto userDto, String email) {
        userRepository.updateUser(userDto.getName(), passwordEncoder.encode(userDto.getPassword()), email);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return fromModelList(userRepository.findAll());
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        return fromModel(userRepository.save(
                User.builder()
                        .name(userDto.getName())
                        .email(userDto.getEmail())
                        .password(userDto.getPassword())
                        .role(User.Role.USER)
                        .state(User.State.NOT_CONFIRMED)
                        .build()));
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return fromModel(userRepository.getById(userId));
    }

    @Override
    public void deleteUserById(Integer userId) {
        User user = userRepository.getById(userId);
        userRepository.delete(user);
    }

    @Override
    public void updateState(String confirmCode) {
        User user = userRepository.findAllByConfirmCode(confirmCode);
        if (user == null) {
            throw new AccountNotExistsException();
        }
        user.setState(User.State.CONFIRMED);
        userRepository.save(user);
    }
}
