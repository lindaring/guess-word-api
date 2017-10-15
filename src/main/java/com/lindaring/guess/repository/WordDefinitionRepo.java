package com.lindaring.guess.repository;
 
import com.lindaring.guess.model.WordDefinition;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WordDefinitionRepo extends CrudRepository<WordDefinition, Integer>{
    
    List<WordDefinition> findByWordWordId(int wordId);
    
}
