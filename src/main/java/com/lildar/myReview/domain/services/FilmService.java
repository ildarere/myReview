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
}
