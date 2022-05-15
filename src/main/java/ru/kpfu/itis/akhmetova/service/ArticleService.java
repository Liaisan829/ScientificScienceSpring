package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();
    List<ArticleDto> getUserArticles(Integer userId);
    void save(ArticleForm form, User user);
}
