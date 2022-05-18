package ru.kpfu.itis.akhmetova.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminRestController {

    private final UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/admin/addUser")
    public ResponseEntity<UserDto> addTasks(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(userDto));
    }

    @DeleteMapping("admin/deleteUser/{userId}")
    public void deleteTask(@PathVariable("userId") Integer userId) {
        userService.deleteUserById(userId);
    }
}
