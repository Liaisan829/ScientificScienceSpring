package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ProfileController {
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal AccountUserDetails userDetails, Model model){
        Optional<User> userByEmail = userService.getUserByEmail(userDetails.getUsername());
        if(userByEmail.isPresent()){
            User user = userByEmail.get();
            model.addAttribute("user", user);
        }
        return "profile";
    }

    @GetMapping("/profile/update")
    public String editPage(Model model){
        model.addAttribute("userDto", new UserDto());
        return "editPage";
    }
}
