package com.lildar.myReview.data.library;

import com.lildar.myReview.domain.model.Film;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends CrudRepository<Film, Integer> {

    @Query(" select films.id, films.name, films.description, films.country, films.number_of_rated, films.sum_of_grades, films.date from film_genre" +
            " left join genres on id_genre = genres.id" +
            " left join films on id_film = films.id" +
            " where films.country like :country and films.date  between :date1 and :date2 and genres.genre= :genre")
    List<Film> getFilmsByFilters(String country, String genre, String date1, String date2);

    @Override
    @Query("select * from films where id = :id")
    Optional<Film> findById(Integer id);
}
