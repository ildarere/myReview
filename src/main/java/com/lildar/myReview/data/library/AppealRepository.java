package com.lildar.myReview.data.library;

import com.lildar.myReview.domain.model.Appeal;
import com.lildar.myReview.domain.model.Film;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppealRepository extends CrudRepository<Appeal, Integer> {
    @Query("DELETE FROM  appeal " +
            "where id_post = :id ")
    void deletebyPostId(int id);
@Query("INSERT INTO appeal ( id_post) " +
        "          VALUES ( :postId)")
    void saveByFilmId(int postId);
}
