package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.akhmetova.dto.ArticleCommentForm;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ArticleCommentService;
import ru.kpfu.itis.akhmetova.service.ArticleService;

@Controller
@RequiredArgsConstructor
public class ArticleCommentController {
    private final ArticleCommentService articleCommentService;
    private final ArticleService articleService;

    @PostMapping("/createComment/{articleId}")
    public String addComment(@PathVariable("articleId") Integer articleId, ArticleCommentForm form, Authentication authentication){
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        articleCommentService.save(form, articleId, user.getId());
        return "redirect:/articles/{articleId}";
    }
}
