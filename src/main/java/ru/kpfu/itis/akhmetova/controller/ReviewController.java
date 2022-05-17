package ru.kpfu.itis.akhmetova.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.akhmetova.dto.ReviewDto;
import ru.kpfu.itis.akhmetova.dto.ReviewForm;
import ru.kpfu.itis.akhmetova.model.User;
import ru.kpfu.itis.akhmetova.security.details.AccountUserDetails;
import ru.kpfu.itis.akhmetova.service.ReviewService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public String reviews(Model model){
        List<ReviewDto> reviewList = reviewService.getAllReviews();
        model.addAttribute("reviews", reviewList);
        return "reviews";
    }

    @PostMapping("/reviews/add")
    public String addArticle(ReviewForm form, Authentication authentication) {
        User user = ((AccountUserDetails) authentication.getPrincipal()).getUser();
        reviewService.save(form, user.getId());
        return "redirect:/reviews";
    }
}
