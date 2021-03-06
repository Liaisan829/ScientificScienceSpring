package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.akhmetova.dto.ArticleForm;
import ru.kpfu.itis.akhmetova.model.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findAllByUserId(Integer userId);
    List<Article> findAllByTitleLike(String title);
    void save(ArticleForm form);
    void deleteArticleById(Integer id);
}
