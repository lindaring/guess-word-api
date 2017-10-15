package com.lindaring.guess.repository;

import com.lindaring.guess.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer>{
    
}
