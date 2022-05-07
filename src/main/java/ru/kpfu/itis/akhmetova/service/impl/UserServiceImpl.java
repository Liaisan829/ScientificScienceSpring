package ru.kpfu.itis.akhmetova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    TODO доделать хэширование пароля
//    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        return UserDto.fromModel(userRepository.save(new User(
                createUserDto.getName(),
                createUserDto.getEmail(),
                createUserDto.getPassword())));
    }
}
