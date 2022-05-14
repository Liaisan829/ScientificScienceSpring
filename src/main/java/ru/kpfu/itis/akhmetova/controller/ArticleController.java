package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ArticleService;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

//    @GetMapping("/articles")
//    public String articles(){
//        return "articles";
//    }

    @GetMapping("/articles")
    public String getUserArticle (Model model , Authentication authentication){
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        model.addAttribute("articles", articleService.getUserArticles(user.getId()));
        return "articles";
    }
}
