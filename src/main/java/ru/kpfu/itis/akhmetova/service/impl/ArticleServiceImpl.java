package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;
import ru.kpfu.itis.akhmetova.model.Article;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.ArticleRepository;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.ArticleService;

import java.util.List;

import static ru.kpfu.itis.akhmetova.dto.ArticleDto.fromModel;
import static ru.kpfu.itis.akhmetova.dto.ArticleDto.fromModelList;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articleList = articleRepository.findAll();

        return fromModelList(articleList);
    }

    @Override
    public List<ArticleDto> getUserArticles(Integer userId) {
        return fromModelList(articleRepository.findAllByUserId(userId));
    }

    @Override
    public void save(ArticleForm form, Integer userId) {

        User user = userRepository.getById(userId);

        Article article = Article.builder()
                .title(form.getTitle())
                .text(form.getText())
                .user(user)
                .build();

        articleRepository.save(article);
    }

    @Override
    public List<ArticleDto> searchArticleByTitle(String title) {
        return fromModelList(articleRepository.findAllByTitleLike('%' + title + '%'));
    }

    @Transactional
    @Override
    public void deleteArticleById(Integer articleId) {
        articleRepository.deleteArticleById(articleId);
    }

    @Override
    public ArticleDto getArticleById(Integer articleId) {
        return fromModel(articleRepository.getById(articleId));
    }

}
