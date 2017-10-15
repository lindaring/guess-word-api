package com.lindaring.guess.repository;
 
import com.lindaring.guess.model.Pos;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PosRepo extends CrudRepository<Pos, Integer>{
    
    List<Pos> findByName(String name);
    
}
