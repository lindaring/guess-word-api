package com.lindaring.guess.repository;
 
import com.lindaring.guess.model.Login;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginRepo extends CrudRepository<Login, Integer>{

    List<Login> findByIpAddress(String ip);

}
