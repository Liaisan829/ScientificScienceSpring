package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;
import ru.kpfu.itis.akhmetova.model.Article;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articles")
    public String articles(Model model) {
        List<ArticleDto> articleList = articleService.getAllArticles();
        model.addAttribute("articles", articleList);
        return "articles";
    }

    @PostMapping("/articles")
    public String addArticle(@RequestBody ArticleForm form, Authentication authentication) {
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        articleService.save(form, user);
        return "redirect:/";
    }

}
