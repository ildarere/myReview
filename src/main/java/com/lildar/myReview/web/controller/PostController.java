package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {
    @Autowired
    ReviewService reviewService;
    @GetMapping("/blogPost{id}")
    public String indexPage(@PathVariable int id, Model model) {
        System.out.println(reviewService.getReviewById(id).get().toString());
        model.addAttribute("reviewInf", reviewService.getReviewById(id).get());

        return "post";
    }
}
