package com.lindaring.guess.repository;

import com.lindaring.guess.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer>{

    List<User> findByNameAndScore(String name, int score);

    List<User> findAllByOrderByScoreDesc();

}
