package ru.kpfu.itis.akhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.akhmetova.model.Review;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private Integer id;
    private String text;
    private String userName;

    public static ReviewDto fromModel(Review review){
        return ReviewDto.builder()
                .id(review.getId())
                .text(review.getText())
                .userName(review.getUser().getName())
                .build();
    }

    public static List<ReviewDto> fromModelList(List<Review> reviews){
        return reviews.stream().map(ReviewDto::fromModel).collect(Collectors.toList());
    }
}
