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

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void addRating(int filmId, int rating) {
        reviewRepository.addRating(filmId, rating);
    }

    @Override
    public List<Review> getLast3Review() {
        return reviewRepository.getLast3Review();
    }

    @Override
    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }
}
