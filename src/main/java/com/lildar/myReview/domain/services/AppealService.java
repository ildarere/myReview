package com.lildar.myReview.domain.services;

import com.lildar.myReview.domain.model.Appeal;

import java.util.List;

public interface AppealService {
    List<Appeal> getAll();
    void deleteById(int id);
    void deleteByPostId(int id);

    void addAppeal(Appeal appeal);
}
