package ru.kpfu.itis.akhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.akhmetova.model.Article;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Integer id;
    private String title;
    private String text;
    private Integer userId;
    private String userName;

    public static ArticleDto fromModel(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .text(article.getText())
                .userId(article.getUser().getId())
                .userName(article.getUser().getName())
                .build();
    }

    public static List<ArticleDto> fromModelList(List<Article> articles){
        return articles.stream().map(ArticleDto::fromModel).collect(Collectors.toList());
    }
}
