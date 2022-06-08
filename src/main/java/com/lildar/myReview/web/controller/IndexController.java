package com.lildar.myReview.web.controller;


import com.lildar.myReview.domain.services.FilmService;
import com.lildar.myReview.domain.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class IndexController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    FilmService filmService;
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("reviews", reviewService.getLast3Review());
        model.addAttribute("films", filmService.getLast3Films());
        return "index";
    }

}
