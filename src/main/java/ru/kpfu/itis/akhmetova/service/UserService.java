package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;

public interface UserService {
    UserDto save(CreateUserDto createUserDto);
}
