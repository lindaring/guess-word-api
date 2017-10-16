package com.lindaring.guess.repository;

import com.lindaring.guess.model.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordRepo extends CrudRepository<Word, Integer> {
    
    List<Word> findByWord(String word);
    
    List<Word> findByEnabled(int enabled);
     
}
