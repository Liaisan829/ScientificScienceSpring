package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.akhmetova.dto.ArticleCommentDto;
import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ArticleCommentService;
import ru.kpfu.itis.akhmetova.service.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleCommentService articleCommentService;

    @GetMapping("/articles")
    public String articles(Model model) {
        List<ArticleDto> articleList = articleService.getAllArticles();
        model.addAttribute("articles", articleList);
        return "articles";
    }

    @PostMapping("/articles/add")
    public String addArticle(ArticleForm form, Authentication authentication) {
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        articleService.save(form, user.getId());
        return "redirect:/articles";
    }

    @GetMapping(value = "/articles/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ArticleDto> searchPostByTitle(@PathVariable("title") String title) {
        return articleService.searchArticleByTitle(title);
    }

    @GetMapping("/articles/{articleId}")
    public String oneArticle(@PathVariable("articleId") Integer articleId, Model model) {
        ArticleDto articleDto = articleService.getArticleById(articleId);
        List<ArticleCommentDto> articleComments = articleCommentService.getAllByArticleId(articleDto.getId());
        model.addAttribute("article", articleDto);
        model.addAttribute("articleComments", articleComments);
        return "oneArticle";
    }

}
