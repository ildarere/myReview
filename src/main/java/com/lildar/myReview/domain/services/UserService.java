package com.lildar.myReview.domain.services;

import com.lildar.myReview.domain.model.User;
import com.lildar.myReview.web.form.user.UserForm;

import javax.validation.Valid;
import java.util.Optional;

public interface UserService {
    Optional<User> findByEmailAndEnabledTrue(String email);
    Optional<User> findByEmail(String username);
    boolean isUserWithEmailExist(String email);
    void update(@Valid UserForm userForm);
}
