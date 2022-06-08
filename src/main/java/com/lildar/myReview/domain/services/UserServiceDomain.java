package com.lildar.myReview.domain.services;

import com.lildar.myReview.data.user.UserRepository;
import com.lildar.myReview.domain.model.Role;
import com.lildar.myReview.domain.model.User;
import com.lildar.myReview.web.form.user.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
@Service
public class UserServiceDomain implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passEncoder;

    @Override
    public Optional<User> findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public boolean isUserWithEmailExist(String email) {
        return  userRepository.countByEmail(email) != 0 ? true : false;
    }

    @Override
    public Optional<User> findByEmailAndEnabledTrue(String email) {
        return Optional.empty();
    }

    @Override
    public void update(@Valid UserForm userForm) {
        User u = new User();
        BeanUtils.copyProperties(userForm, u, "password");
        u.setPassword(passEncoder.encode(userForm.getPassword()));
        u.setRoles(Role.USER.toString());
        userRepository.save(u);
        userRepository.findByEmailAndEnabledTrue(u.getEmail());
    }

    @Override
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }
}
