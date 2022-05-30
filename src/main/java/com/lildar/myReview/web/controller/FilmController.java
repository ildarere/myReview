package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.model.Genre;
import com.lildar.myReview.domain.services.FilmService;
import com.lildar.myReview.domain.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class FilmController {
    @Autowired
    FilmService filmService;
    @Autowired
    ReviewService reviewService;
    @GetMapping("/film{id}")
    public String film(@PathVariable int id, Model model) {
        Film film= filmService.getFilmById(id).get();
        model.addAttribute("film", film );
        model.addAttribute("genres",filmService.getGenresById(id) );
        model.addAttribute("Rating", film.getRating() );
        model.addAttribute("reviews",reviewService.getReviewByFilmId(id));
        return "film";
    }
}
