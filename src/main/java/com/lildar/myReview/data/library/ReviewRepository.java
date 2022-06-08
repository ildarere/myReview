package com.lildar.myReview.data.library;

import com.lildar.myReview.domain.model.Review;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query("select * from review where id_author = :id")
    List<Review> getReviewByAuthorId(int id);

    @Query("select * from review where id_film = :id ;")
    List<Review> findReviewByFilmId(int id);
    @Query("update films " +
            " set number_of_rated = number_of_rated + 1, " +
            " sum_of_grades = sum_of_grades + :rating" +
            " where id = :filmId ")
    @Modifying
    void addRating(int filmId, int rating);
    @Query("SELECT * FROM review ORDER BY id DESC LIMIT 3")
    List<Review> getLast3Review();
}
