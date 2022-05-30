package com.lildar.myReview.web.controller;

import com.lildar.myReview.domain.services.UserService;
import com.lildar.myReview.web.form.user.UserForm;
import com.lildar.myReview.web.form.user.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(userFormValidator);
    }

    @GetMapping(path = {"/registration/{userId}", "/registration"})
    public String userRegistration(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "/user/registration";
    }


    @PostMapping("/registration")
    public String userRegistrationSubmit(@ModelAttribute @Valid UserForm userForm,
                                         BindingResult result) {

        if (result.hasErrors()) {
            return "/registration";
        } else {
            userService.update(userForm);
        }

        return "redirect:/";
    }
}
