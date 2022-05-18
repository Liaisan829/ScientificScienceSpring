package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.ArticleCommentDto;
import ru.kpfu.itis.akhmetova.dto.ArticleCommentForm;
import ru.kpfu.itis.akhmetova.model.Article;
import ru.kpfu.itis.akhmetova.model.ArticleComment;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.ArticleCommentsRepository;
import ru.kpfu.itis.akhmetova.repository.ArticleRepository;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.ArticleCommentService;

import java.util.List;

import static ru.kpfu.itis.akhmetova.dto.ArticleCommentDto.fromModelList;

@RequiredArgsConstructor
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
    private final ArticleCommentsRepository articleCommentsRepository;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Override
    public void save(ArticleCommentForm form, Integer articleId, Integer userId) {
        Article article = articleRepository.getById(articleId);
        User user = userRepository.getById(userId);

        ArticleComment articleComment = ArticleComment.builder()
                .text(form.getText())
                .user(user)
                .article(article)
                .build();

        articleCommentsRepository.save(articleComment);
    }

    @Override
    public List<ArticleCommentDto> getAllByArticleId(Integer articleId) {
        List<ArticleComment> articleComments = articleCommentsRepository.getArticleCommentsByArticleId(articleId);

        return fromModelList(articleComments);
    }
}
