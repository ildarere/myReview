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
    @Query("select * from films where name like :name")
    List<Film> getFilmsByName(String name);
    @Override
    @Query("select * from films where id = :id")
    Optional<Film> findById(Integer id);
    @Query("select Count(id_film) from favoriteList where id_user = :userId")
    int getFavoriteListCountByUserId(int userId);
    @Query("select Count(id_film) from viewed_films where id_user = :userId")
    int getViewedListCountByUserId(int userId);
    @Query("select Count(id_film) from  planning_films where id_user = :userId")
    int getPlanningListCountByUserId(int userId);
    @Query("select Count(id_film) from abandoned_films where id_user = :userId")
    int getAbandonedListCountByUserId(int userId);
    @Query("select films.id, films.name, films.description, films.country, films.number_of_rated , films.sum_of_grades, films.date from favoriteList " +
            " left join films on id_film = films.id" +
            " where id_user = :userId ")
    List<Film> getFavoriteFilms(int userId);

    @Query("select films.id, films.name, films.description, films.country, films.number_of_rated , films.sum_of_grades, films.date from viewed_films " +
            " left join films on id_film = films.id" +
            " where id_user = :userId ")
    List<Film> getViewedFilms(int userId);

    @Query("select films.id, films.name, films.description, films.country, films.number_of_rated , films.sum_of_grades, films.date from planning_films " +
            " left join films on id_film = films.id" +
            " where id_user = :userId ")
    List<Film> getPlanningFilms(int userId);
    @Query("select films.id, films.name, films.description, films.country, films.number_of_rated , films.sum_of_grades, films.date from abandoned_films " +
            " left join films on id_film = films.id" +
            " where id_user = :userId ")
    List<Film> getAbandonedFilms(int userId);
    @Query("insert into viewed_films (id_user, id_film) " +
            "values(:userId, :filmId)")
    void setFilmViewed(int filmId, int userId);
    @Query("DELETE FROM viewed_films " +
            "where id_film = :filmId and id_user = :userId")
    void deleteViewedFilm(int filmId, int userId);
    @Query("select Count(*) from viewed_films " +
            "where id_film = :filmId and id_user = :userId")
    int isViewed(int filmId, int userId);
    @Query("DELETE FROM favoriteList " +
            "where id_film = :filmId and id_user = :userId")
    void deleteFromFavList(int filmId, int userId);
    @Query("DELETE FROM planning_films " +
            "where id_film = :filmId and id_user = :userId")
    void deleteFromPlanList(int filmId, int userId);
    @Query("DELETE FROM  abandoned_films " +
            "where id_film = :filmId and id_user = :userId")
    void deleteFromAbandonedList(int filmId, int userId);


    @Query("INSERT INTO favoriteList (id_user , id_film) " +
            "VALUES ( :userId, :filmId)")
    void addInFavList(int filmId, int userId);
    @Query("INSERT INTO planning_films (id_user , id_film) " +
            "VALUES ( :userId, :filmId)")
    void addInPlanList(int filmId, int userId);
    @Query("INSERT INTO  abandoned_films (id_user , id_film) " +
            "VALUES ( :userId, :filmId)")
    void addInAbandonedList(int filmId, int userId);


    @Query("select Count(*) from favoriteList " +
            "where id_film = :filmId and id_user = :userId")
    int isInFavorite(int filmId, int userId);
    @Query("select Count(*) from planning_films " +
            "where id_film = :filmId and id_user = :userId")
    int isInPlan(int filmId, int userId);
    @Query("select Count(*) from abandoned_films " +
            "where id_film = :filmId and id_user = :userId")
    int isInAbandoned(int filmId, int userId);

    @Query("SELECT * FROM films ORDER BY id DESC LIMIT 3")
    List<Film> getLast3Films();
}
