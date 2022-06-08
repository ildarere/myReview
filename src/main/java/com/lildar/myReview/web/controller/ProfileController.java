package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.model.User;
import com.lildar.myReview.domain.services.FilmService;
import com.lildar.myReview.domain.services.ReviewService;
import com.lildar.myReview.domain.services.UserService;
import com.lildar.myReview.web.spring.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    FilmService filmService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    UserService userService;
    @GetMapping("/me")
    public String profile(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentId =Math.toIntExact(((UserDetailsImpl) principal).getId());
        model.addAttribute("userId", currentId);
        model.addAttribute("Name", ((UserDetailsImpl) principal).getName());
        model.addAttribute("FavFilms", filmService.getFavoriteListCountByUserId(currentId));
        model.addAttribute("ViewedFilms", filmService.getViewedListCountByUserId(currentId));
        model.addAttribute("PlanningFilms", filmService.getPlanningListCountByUserId(currentId));
        model.addAttribute("BanFilms", filmService.getAbandonedListCountByUserId(currentId));
        model.addAttribute("reviews",reviewService.getReviewByAuthorId(currentId));
        return "Profile";
    }
    @GetMapping("/user{id}")
    public String profileUsers(@PathVariable int id, Model model){
        int currentId =id;
        User u = userService.findById(id).get();
        model.addAttribute("userId", currentId);
        model.addAttribute("Name", u.getName());
        model.addAttribute("FavFilms", filmService.getFavoriteListCountByUserId(currentId));
        model.addAttribute("ViewedFilms", filmService.getViewedListCountByUserId(currentId));
        model.addAttribute("PlanningFilms", filmService.getPlanningListCountByUserId(currentId));
        model.addAttribute("BanFilms", filmService.getAbandonedListCountByUserId(currentId));
        model.addAttribute("reviews",reviewService.getReviewByAuthorId(currentId));
        return "Profile";
    }
}
