package ru.kpfu.itis.akhmetova.service;

import ru.kpfu.itis.akhmetova.dto.ReviewDto;
import ru.kpfu.itis.akhmetova.dto.ReviewForm;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getAllReviews();
    void save(ReviewForm form, Integer userId);
}
