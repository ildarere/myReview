package com.lildar.myReview.domain.services;

import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.model.Genre;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    public List<Film> getAllList();
    List<Film> getFilmsByFilters(String country, String genre, String date1, String date2);
    List<Genre> getGenresById(int id);
    Optional<Film> getFilmById(int id);
    List<Integer> getFavoriteListByUserId(int id);
    int getFavoriteListCountByUserId(int userId);
    int getViewedListCountByUserId(int userId);
    int getPlanningListCountByUserId(int userId);
    int getAbandonedListCountByUserId(int userId);
    List<Film> getFavoriteFilms(int userId);
    List<Film> getViewedFilms(int userId);
    List<Film> getPlanningFilms(int userId);
    List<Film> getAbandonedFilms(int userId);

    void setViewed(int filmId, int userId);
    void deleteViewed(int filmId, int userId);
    boolean isViewed(int filmId, int userId);

    void deletFromAllLists(int filmId, int userId);

    void addInFavoriteList(int filmId, int userId);

    void addInPlanList(int filmId, int userId);

    void addInAbandonedList(int filmId, int userId);

    String getList(int filmId, int userId);

    List<Film> getFilmsByName(String name);
    List<Film> getLast3Films();
}
