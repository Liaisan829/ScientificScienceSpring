package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();
    List<ArticleDto> getUserArticles(Integer userId);
    ArticleDto getArticleById(Integer articleId);
    void save(ArticleForm form, Integer userId);
    List<ArticleDto> searchArticleByTitle(String title);
    void deleteArticleById(Integer articleId);
}
