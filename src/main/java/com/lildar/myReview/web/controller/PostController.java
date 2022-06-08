package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.model.Appeal;
import com.lildar.myReview.domain.services.AppealService;
import com.lildar.myReview.domain.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    AppealService appealService;
    @GetMapping("/blogPost{id}")
    public String indexPage(@PathVariable int id, Model model) {
        System.out.println(reviewService.getReviewById(id).get().toString());
        model.addAttribute("reviewInf", reviewService.getReviewById(id).get());

        return "post";
    }
    @PostMapping("/blogPost{id}/delete")
    public void postDelete(@PathVariable int id, @RequestParam(name = "delete", required = false)int reviewJSON) {
        reviewService.deleteById(id);
        appealService.deleteByPostId(id);
    }
    @PostMapping("/blogPost{id}/appearReview")
    public void appealReview(@PathVariable int id, @RequestParam(name = "appearReview", required = false)int reviewJSON) {
        Appeal appeal =new Appeal();
        appeal.setPostId(id);
        appealService.addAppeal(appeal);
    }
}
