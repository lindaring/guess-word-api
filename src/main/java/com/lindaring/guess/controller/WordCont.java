package com.lindaring.guess.controller;

import com.lindaring.guess.exception.NoImplementationException;
import com.lindaring.guess.exception.WordNotFoundException;
import com.lindaring.guess.model.Word;
import com.lindaring.guess.model.WordDefinition;
import com.lindaring.guess.model.custom.WordWithDefinitions;
import com.lindaring.guess.service.WordServ;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/guessword/v1/word")
public class WordCont {

    @Autowired
    WordServ wordServ;

    @ApiOperation(notes="Get the definition of a word", value="Definition of a word")
    @RequestMapping(value="/{wordId}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<WordWithDefinitions> getDefinition(@ApiParam(value="The word id", required=true) @PathVariable int wordId)
            throws WordNotFoundException {
        WordWithDefinitions word = wordServ.getWordDefinition(wordId);
        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @ApiOperation(notes="Check if word already exists", value="Check if word exists")
    @RequestMapping(value="/{word}/exists", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Boolean> isWordExists(@ApiParam(value="The word", required=true) @PathVariable String word)
            throws WordNotFoundException {
        try {
            boolean exists = wordServ.getWord(word) != null;
            return new ResponseEntity<>(exists, HttpStatus.OK);
        } catch (WordNotFoundException e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(notes="Check if the provided word matches the specified definition", value="Is provided word correct?")
    @RequestMapping(value="/{word}/definition/{def}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<Boolean> isWordCorrect(@ApiParam(value="The word", required=true) @PathVariable String word,
            @ApiParam(value="The definition", required=true) @PathVariable String def) throws WordNotFoundException {
        try {
            boolean isCorrect = wordServ.isWordCorrect(word, def);
            return new ResponseEntity<>(isCorrect, HttpStatus.OK);
        } catch (WordNotFoundException e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(notes="Get random list of words limited to the specified number", value="Random list of words")
    @RequestMapping(value="/random/{limit}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Word>> getRandomWords(@ApiParam(value="Maximum number of words returned", required=true) @PathVariable int limit)
            throws NoImplementationException {
        List<Word> words = wordServ.getRandomWords(limit);
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

    @ApiOperation(notes="Add a new word", value="Add a word")
    @RequestMapping(value="/add", method=RequestMethod.POST, produces="application/json")
    public ResponseEntity<Boolean> addWord(@ApiParam(value="New word with list of definitions", required=true) @RequestBody WordWithDefinitions wordWithDefinitions)
            throws NoImplementationException {
        Boolean added = wordServ.addWordDefinition(wordWithDefinitions);        
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

}
