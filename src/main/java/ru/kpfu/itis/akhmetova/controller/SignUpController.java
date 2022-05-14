package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.SignUpForm;
import ru.kpfu.itis.akhmetova.service.UserService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SignUpController {

    private final UserService userService;

    @GetMapping("signUp")
    public String signUp(Authentication authentication, Model model){
        if(authentication != null){
            return "redirect:/";
        }
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("signUpForm", form);
            return "signUp";
        }
        userService.signUp(form);
        return "redirect:/signIn";
    }

//    @GetMapping(value="/confirm")
//    public String accountVerified(@RequestParam(value="code") String confirmCode){
//        accountService.updateState(confirmCode);
//        return "verified";
//    }
}
