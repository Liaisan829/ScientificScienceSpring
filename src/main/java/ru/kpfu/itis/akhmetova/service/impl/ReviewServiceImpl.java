package ru.kpfu.itis.akhmetova.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.akhmetova.dto.ReviewDto;
import ru.kpfu.itis.akhmetova.dto.ReviewForm;
import ru.kpfu.itis.akhmetova.model.Review;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.repository.ReviewRepository;
import ru.kpfu.itis.akhmetova.repository.UserRepository;
import ru.kpfu.itis.akhmetova.service.ReviewService;

import java.util.List;

import static ru.kpfu.itis.akhmetova.dto.ReviewDto.fromModelList;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();

        return fromModelList(reviewList);
    }

    @Override
    public void save(ReviewForm form, Integer userId) {

        User user = userRepository.getById(userId);

        Review review = Review.builder()
                .text(form.getText())
                .user(user)
                .build();

        reviewRepository.save(review);
    }
}
