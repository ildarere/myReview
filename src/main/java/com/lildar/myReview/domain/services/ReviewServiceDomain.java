package com.lildar.myReview.domain.services;

import com.lildar.myReview.data.library.ReviewRepository;
import com.lildar.myReview.domain.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ReviewServiceDomain implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public List<Review> getReviewByAuthorId(int id) {
        return reviewRepository.getReviewByAuthorId(id);
    }

    @Override
    public List<Review> getReviewByFilmId(int id) {
        return reviewRepository.findReviewByFilmId(id);
    }

    @Override
    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }
}
