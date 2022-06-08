package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    FilmService filmService;
    @GetMapping("/user{id}/viewedFilms")
    public String viewedFilms(@PathVariable int id, Model model){
        List<Film> films= filmService.getViewedFilms(id);
        model.addAttribute("films",films);
        model.addAttribute("List","Просмотрено");
        model.addAttribute("userId",id);
        model.addAttribute("backList","abandonedFilms");
        model.addAttribute("nextList","favoriteFilms");
        return "list";
    }
    @GetMapping("/user{id}/favoriteFilms")
    public String favoriteFilms(@PathVariable int id, Model model){
        List<Film> films= filmService.getFavoriteFilms(id);
        model.addAttribute("films",films);
        model.addAttribute("List","Любимые");
        model.addAttribute("userId",id);
        model.addAttribute("backList","viewedFilms");
        model.addAttribute("nextList","planningFilms");
        return "list";
    }

    @GetMapping("/user{id}/planningFilms")
    public String planningFilms(@PathVariable int id, Model model){
        List<Film> films= filmService.getPlanningFilms(id);
        model.addAttribute("films",films);
        model.addAttribute("List","В планах");
        model.addAttribute("userId",id);
        model.addAttribute("backList","favoriteFilms");
        model.addAttribute("nextList","abandonedFilms");
        return "list";
    }
    @GetMapping("/user{id}/abandonedFilms")
    public String abandonedFilms(@PathVariable int id, Model model){
        List<Film> films= filmService.getAbandonedFilms(id);
        model.addAttribute("films",films);
        model.addAttribute("List","Брошено");
        model.addAttribute("userId",id);
        model.addAttribute("backList","planningFilms");
        model.addAttribute("nextList","viewedFilms");
        return "list";
    }
}
