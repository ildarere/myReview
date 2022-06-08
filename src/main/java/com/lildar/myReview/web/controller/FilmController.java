package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.model.Genre;
import com.lildar.myReview.domain.services.FilmService;
import com.lildar.myReview.domain.services.ReviewService;
import com.lildar.myReview.web.spring.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentId =Math.toIntExact(((UserDetailsImpl) principal).getId());
        String list = filmService.getList(id, currentId);
        model.addAttribute(list,"selected" );
        model.addAttribute("isViewed", filmService.isViewed(id, currentId));
        model.addAttribute("film", film );
        model.addAttribute("filmId", id );
        model.addAttribute("genres",filmService.getGenresById(id) );
        model.addAttribute("Rating", film.getRating() );
        model.addAttribute("reviews",reviewService.getReviewByFilmId(id));
        return "film";
    }

    @PostMapping("film{id}/getViewed")
    @ResponseBody
    public void getViewed(@PathVariable int id,@RequestParam(name = "isViewed", required = false)Boolean isViewed ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentId =Math.toIntExact(((UserDetailsImpl) principal).getId());
        if(isViewed){
            filmService.setViewed(id,currentId );
        }else if(!isViewed){
            filmService.deleteViewed(id,currentId);
        }
    }
    @PostMapping("film{id}/setList")
    @ResponseBody
    public void setList(@PathVariable int id,@RequestParam(name = "list", required = false)String list ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentId =Math.toIntExact(((UserDetailsImpl) principal).getId());
        if(list.equals("none")){
            filmService.deletFromAllLists(id, currentId);
        }
        if(list.equals("fav")){
            filmService.addInFavoriteList(id, currentId);
        }
        if(list.equals("plan")){
            filmService.addInPlanList(id, currentId);
        }
        if(list.equals("abad")){
            filmService.addInAbandonedList(id, currentId);
        }

    }
}
