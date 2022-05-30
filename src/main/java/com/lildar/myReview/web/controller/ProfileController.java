package com.lildar.myReview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/me")
    public String profile(){

        return "Profile";
    }
}
