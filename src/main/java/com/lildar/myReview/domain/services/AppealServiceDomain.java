package com.lildar.myReview.domain.services;

import com.lildar.myReview.data.library.AppealRepository;
import com.lildar.myReview.domain.model.Appeal;
import com.lildar.myReview.domain.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppealServiceDomain implements AppealService{
    @Autowired
    AppealRepository appealRepository;
    @Override
    public List<Appeal> getAll() {
        List<Appeal> appeals = new ArrayList<>();
        appealRepository.findAll().forEach(appeals::add);
        return appeals;
    }

    @Override
    public void deleteById(int id) {
        appealRepository.deleteById(id);
    }

    @Override
    public void deleteByPostId(int id) {
        appealRepository.deletebyPostId(id);
    }

    @Override
    public void addAppeal(Appeal appeal) {
        appealRepository.save(appeal);
    }
}
