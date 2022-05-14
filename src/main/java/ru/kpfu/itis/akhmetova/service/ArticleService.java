package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAllArticles();
    List<ArticleDto> getUserArticles(Integer userId);

}
