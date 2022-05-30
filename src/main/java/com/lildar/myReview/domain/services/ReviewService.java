package com.lildar.myReview.domain.services;


import com.lildar.myReview.domain.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getReviewByAuthorId(int id);
    List<Review> getReviewByFilmId(int id);
    Optional<Review> getReviewById(int id);
}
