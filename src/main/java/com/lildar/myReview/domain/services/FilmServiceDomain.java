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
}
