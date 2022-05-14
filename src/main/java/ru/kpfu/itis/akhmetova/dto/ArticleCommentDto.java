package ru.kpfu.itis.akhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.akhmetova.model.Article;
import ru.kpfu.itis.akhmetova.model.ArticleComment;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleCommentDto {
    private Integer id;
    private String text;
    private User user;
    private Article article;

    public static ArticleCommentDto fromModel(ArticleComment articleComment){
        return ArticleCommentDto.builder()
                .id(articleComment.getId())
                .text(articleComment.getText())
                .user(articleComment.getUser())
                .article(articleComment.getArticle())
                .build();
    }

    public static List<ArticleCommentDto> fromModelList(List<ArticleComment> articleComments){
        return articleComments.stream().map(ArticleCommentDto::fromModel)
                .collect(Collectors.toList());
    }
}
