package com.lildar.myReview.domain.services;

import com.lildar.myReview.data.library.GenreRepository;
import com.lildar.myReview.data.library.LibraryRepository;
import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceDomain implements FilmService{
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<Film> getFilmsByFilters(String country, String genre, String date1, String date2) {
        return libraryRepository.getFilmsByFilters(country, genre, date1, date2);
    }

    @Override
    public List<Film> getAllList() {
        List<Film> films = new ArrayList<>();
        libraryRepository.findAll().forEach(films::add);
        return films;
    }

    @Override
    public List<Genre> getGenresById(int id) {
        return genreRepository.findAllById(id);
    }

    @Override
    public Optional<Film> getFilmById(int id) {
        return libraryRepository.findById(id);
    }

    @Override
    public List<Integer> getFavoriteListByUserId(int id) {
        return null;
    }

    @Override
    public int getFavoriteListCountByUserId(int userId) {
        return libraryRepository.getFavoriteListCountByUserId(userId);
    }

    @Override
    public int getViewedListCountByUserId(int userId) {
        return libraryRepository.getViewedListCountByUserId(userId);
    }

    @Override
    public int getPlanningListCountByUserId(int userId) {
        return libraryRepository.getPlanningListCountByUserId(userId);
    }

    @Override
    public int getAbandonedListCountByUserId(int userId) {
        return libraryRepository.getAbandonedListCountByUserId(userId);
    }

    @Override
    public List<Film> getFavoriteFilms(int userId) {
        return libraryRepository.getFavoriteFilms(userId);
    }

    @Override
    public List<Film> getViewedFilms(int userId) {
        return libraryRepository.getViewedFilms(userId);
    }

    @Override
    public List<Film> getPlanningFilms(int userId) {
        return libraryRepository.getPlanningFilms(userId);
    }

    @Override
    public List<Film> getAbandonedFilms(int userId) {
        return libraryRepository.getAbandonedFilms(userId);
    }

    @Override
    public void setViewed(int filmId, int userId) {
        libraryRepository.setFilmViewed(filmId,userId);
    }

    @Override
    public void deleteViewed(int filmId, int userId) {
        libraryRepository.deleteViewedFilm(filmId,userId);
    }

    @Override
    public boolean isViewed(int filmId, int userId) {
        return  libraryRepository.isViewed(filmId, userId) != 0 ? true : false;
    }

    @Override
    public void deletFromAllLists(int filmId, int userId) {
        libraryRepository.deleteFromFavList(filmId,userId);
        libraryRepository.deleteFromPlanList(filmId,userId);
        libraryRepository.deleteFromAbandonedList(filmId,userId);
    }

    @Override
    public void addInFavoriteList(int filmId, int userId) {
        libraryRepository.deleteFromPlanList(filmId,userId);
        libraryRepository.deleteFromAbandonedList(filmId,userId);
        libraryRepository.addInFavList(filmId,userId);
    }

    @Override
    public void addInPlanList(int filmId, int userId) {
        libraryRepository.deleteFromFavList(filmId,userId);
        libraryRepository.deleteFromAbandonedList(filmId,userId);
        libraryRepository.addInPlanList(filmId,userId);
    }

    @Override
    public void addInAbandonedList(int filmId, int userId) {
        libraryRepository.deleteFromFavList(filmId,userId);
        libraryRepository.deleteFromPlanList(filmId,userId);
        libraryRepository.addInAbandonedList(filmId,userId);
    }

    @Override
    public String getList(int filmId, int userId) {
        if(libraryRepository.isInFavorite(filmId, userId) != 0){
            return "Fav";
        }
        if(libraryRepository.isInPlan(filmId, userId) != 0){
            return "Plan";
        }
        if(libraryRepository.isInAbandoned(filmId, userId) != 0){
            return "Abandoned";
        }
        return "none";
    }

    @Override
    public List<Film> getFilmsByName(String name) {
        return libraryRepository.getFilmsByName(name);
    }

    @Override
    public List<Film> getLast3Films() {
        return libraryRepository.getLast3Films();
    }
}
