package com.lildar.myReview.data.library;

import com.lildar.myReview.domain.model.Review;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query("select * from review where id_author = :id")
    List<Review> getReviewByAuthorId(int id);

    @Query("select * from review where id_film = :id ;")
    List<Review> findReviewByFilmId(int id);
}
