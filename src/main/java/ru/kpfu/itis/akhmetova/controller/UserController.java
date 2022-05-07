package ru.kpfu.itis.akhmetova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.CreateUserDto;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("name"));
    }

//    @GetMapping("/user")
//    public Iterable<UserDto> getAll() {
//        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
//    }
//
//    @GetMapping("/user/{id}")
//    public UserDto get(@PathVariable Integer id) {
//        return userRepository.findById(id).stream().map(UserDto::fromModel).findFirst().orElse(null);
//    }

    @GetMapping("sign-up")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/sign-up")
    public UserDto signUp(@Valid @RequestBody CreateUserDto createUserDto) {
        return userService.save(createUserDto);
    }
}
