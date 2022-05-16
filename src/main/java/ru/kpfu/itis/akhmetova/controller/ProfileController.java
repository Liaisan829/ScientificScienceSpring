package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.akhmetova.dto.UserDto;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ArticleService;
import ru.kpfu.itis.akhmetova.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ProfileController {
    private final UserService userService;
    private final ArticleService articleService;

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
    public String getEditPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "editPage";
    }

    @PostMapping("/profile/update")
    public String update(Model model, @Valid UserDto userDto, BindingResult result, @AuthenticationPrincipal AccountUserDetails userDetails){
        if(result.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "editPage";
        }
        String email = userDetails.getUsername();
        userService.update(userDto, email);
        return "redirect:/profile";
    }

    @GetMapping("/myArticles")
    public String getUserArticle (Model model, Authentication authentication){
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        model.addAttribute("articles", articleService.getUserArticles(user.getId()));
        return "myArticles";
    }

    @PostMapping("/myArticles/{article-id}/delete")
    public String deleteArticle(@PathVariable("article-id") Integer articleId){
        articleService.deleteArticleById(articleId);
        return "redirect:/myArticles";
    }
}
