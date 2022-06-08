package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.services.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppealController {
    @Autowired
    AppealService appealService;
    @GetMapping("/appeal")
    public String indexPage(Model model) {
       model.addAttribute("appeals", appealService.getAll());
        return "appeal";
    }

    @PostMapping("/appeal/delete")
    @ResponseBody
    public void postDelete(@RequestParam(name = "id", required = false)int id) {
        appealService.deleteById(id);
    }

}
