package com.lildar.myReview.data.library;

import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.model.Genre;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    @Query("select id_genre as id, genres.genre from film_genre" +
            " left join genres on id_genre = genres.id" +
            " where id_film = :id and id_genre!=1 ")
    List<Genre> findAllById(int id);


}
