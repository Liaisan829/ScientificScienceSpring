package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.ArticleDto;
import ru.kpfu.itis.akhmetova.model.Article;
import ru.kpfu.itis.akhmetova.repository.ArticleRepository;
import ru.kpfu.itis.akhmetova.service.ArticleService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articleList = articleRepository.findAll();

        return ArticleDto.fromModelList(articleList);
    }

    @Override
    public List<ArticleDto> getUserArticles(Integer userId) {
        return ArticleDto.fromModelList(articleRepository.findAllByUserId(userId));
    }
}
