package com.lildar.myReview.data.user;

import com.lildar.myReview.domain.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    @Query("update user set enabled = 1 where email = :email")
    @Modifying
    Optional<User> findByEmailAndEnabledTrue(String email);

    long countByEmail(String email);
}
