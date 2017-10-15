package com.lindaring.guess.repository;
 
import com.lindaring.guess.model.Definition;
import org.springframework.data.repository.CrudRepository;

public interface DefinitionRepo extends CrudRepository<Definition, Integer>{
    
}
