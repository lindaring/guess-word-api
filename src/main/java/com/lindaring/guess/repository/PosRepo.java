package com.lindaring.guess.repository;

import com.lindaring.guess.model.Pos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PosRepo extends CrudRepository<Pos, Integer>{
    
    List<Pos> findByName(String name);
    
}
