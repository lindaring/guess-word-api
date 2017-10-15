package com.lindaring.guess.repository;
 
import com.lindaring.guess.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepo extends CrudRepository<Login, Integer>{
    
}
