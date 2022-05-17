package ru.kpfu.itis.akhmetova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.akhmetova.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
