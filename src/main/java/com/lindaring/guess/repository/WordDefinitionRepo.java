package com.lindaring.guess.repository;

import com.lindaring.guess.model.WordDefinition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordDefinitionRepo extends CrudRepository<WordDefinition, Integer>{
    
    List<WordDefinition> findByWordWordId(int wordId);
    
}
