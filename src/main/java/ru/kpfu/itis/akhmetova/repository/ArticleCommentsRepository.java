package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.akhmetova.model.ArticleComment;

import java.util.List;

public interface ArticleCommentsRepository extends JpaRepository<ArticleComment, Integer> {
    @Query(value = "select from article_comment where article_id in " +
            "(select id from article where article.user_id = :user_id)",
            nativeQuery = true)
    List<ArticleComment> getArticleCommentByUserId(@Param("user_id") Integer userId);


    List<ArticleComment> getArticleCommentsByArticleId(Integer articleId);
}
