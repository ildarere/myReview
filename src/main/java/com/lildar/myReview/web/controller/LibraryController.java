package com.lildar.myReview.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lildar.myReview.domain.model.Film;
import com.lildar.myReview.domain.services.FilmService;
import com.lildar.myReview.domain.model.FilmFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    FilmService filmService;
    @GetMapping("/library")
    public String profile(Model model){
        String country= "%%";
        String date1 = "1900-01-01";
        String date2 = "2023-01-10";
        List<Film> films= filmService.getFilmsByFilters(country, "все", date1, date2);
        model.addAttribute("films",films);
        return "library";
    }

    @PostMapping(path = "/library/getFilmsByFilter", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Film> userRegistrationSubmit(@RequestParam(name = "filter", required = false)String jsonText) {


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FilmFilter filter= gson.fromJson(jsonText, FilmFilter.class);
        String date1 = filter.getYears();
        String date2 = "2023-01-10";
        if(date1==null){
            date1 = "1900-01-01";
        }else {
            String[] dates = date1.split("-");
            if(dates.length>=3){
                date1=dates[0]+"-01-01";
                date2=dates[1] +"-12-30";
            }

        }
        System.out.println(filter.getCountry());
        String country= filter.getCountry();
        if(country.equals("все")){
            country= "%%";
        }
        List<Film> films= filmService.getFilmsByFilters(country, filter.getGenre(), date1, date2);
        System.out.println(films.isEmpty());
        System.out.println(date1+" "+date2);
        for (Film f:films
             ) {


            System.out.println(f.toString());
        }
        return films;
    }
}
