package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.ArticleCommentDto;
import ru.kpfu.itis.akhmetova.dto.ArticleCommentForm;

import java.util.List;

public interface ArticleCommentService {
    void save(ArticleCommentForm form, Integer articleId, Integer userId);
    List<ArticleCommentDto> getAllByArticleId(Integer articleId);
}
