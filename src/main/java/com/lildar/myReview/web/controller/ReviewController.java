package com.lildar.myReview.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lildar.myReview.domain.model.Review;
import com.lildar.myReview.domain.services.ReviewService;
import com.lildar.myReview.web.spring.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/film{id}/writeReview")
    public String review(@PathVariable int id, Model model) {

        model.addAttribute("filmId",id);
        return "writeReview";
    }
    @PostMapping("film{id}/writeReview/addReview")
    @ResponseBody
    public void addReview(@PathVariable int id,@RequestParam(name = "review", required = false)String reviewJSON ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int currentId =Math.toIntExact(((UserDetailsImpl) principal).getId());
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Review review= gson.fromJson(reviewJSON, Review.class);
        review.setIdFilm(id);
        review.setIdAuthor(currentId);
        review.setNameAuthor(((UserDetailsImpl) principal).getName());
        reviewService.addReview(review);
    }
    @PostMapping("film{id}/writeReview/addRating")
    @ResponseBody
    public void addRating(@PathVariable int id,@RequestParam(name = "rating", required = false)String ratingString ){
        System.out.println(ratingString);
        reviewService.addRating(id, Integer.parseInt(ratingString));
    }
}
