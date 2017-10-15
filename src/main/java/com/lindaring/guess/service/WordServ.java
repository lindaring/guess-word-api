package com.lindaring.guess.service;

import com.lindaring.guess.enumerator.Enabled;
import com.lindaring.guess.exception.WordNotFoundException;
import com.lindaring.guess.model.Definition;
import com.lindaring.guess.model.Word;
import com.lindaring.guess.model.WordDefinition;
import com.lindaring.guess.model.custom.WordWithDefinitions;
import com.lindaring.guess.repository.DefinitionRepo;
import com.lindaring.guess.repository.WordDefinitionRepo;
import com.lindaring.guess.repository.WordJdbc;
import com.lindaring.guess.repository.WordRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServ {

    @Autowired
    WordDefinitionRepo wordDefRepo;

    @Autowired
    WordRepo wordRepo;

    @Autowired
    DefinitionRepo defRepo;

    @Autowired
    WordJdbc wordJdbc;

    @Autowired
    PosServ posServ;

    @Autowired
    DefinitionServ defServ;

    private static final Logger log = Logger.getLogger(WordServ.class);

    /**
     * Get a specified word and it definitions.
     *
     * @param wordId the word id.
     * @return the requested word and definitions.
     * @throws WordNotFoundException
     */
        public WordWithDefinitions getWordDefinition(int wordId) throws WordNotFoundException {
        log.debug(String.format("Getting word with id: '%d'...", wordId));
        List<WordDefinition> word = wordDefRepo.findByWordWordId(wordId);

        if (word.size() > 0) {
            //Contruct word with definitions for more readable json response
            log.debug(String.format("Word: '%d' definition found: '%s'", wordId, word));
            List<Definition> definitionList = new ArrayList<>();
            word.stream().forEach(x -> definitionList.add(x.getDefinition()));
            return WordWithDefinitions.builder().word(word.get(0).getWord()).listOfDefinitions(definitionList).build();
        } else {
            throw new WordNotFoundException();
        }
    }

    /**
     * Get the specified word.
     *
     * @param word the word.
     * @return the word.
     * @throws WordNotFoundException
     */
    public Word getWord(String word) throws WordNotFoundException {
        log.debug(String.format("Getting word: '%s'...", word));
        List<Word> lstWord = wordRepo.findByWord(word);

        if (lstWord.size() > 0) {
            log.debug(String.format("Word: '%s' retreived successfully: '%s'", word, lstWord));
            return lstWord.get(0);
        } else {
            throw new WordNotFoundException(word);
        }
    }

    /**
     * Check if the provided word is correct word to the definition.
     *
     * @param word       the word to be checked.
     * @param definition the definition the word will be checked against.
     * @return true if the word matches the definition, otherwise return false.
     * @throws WordNotFoundException
     */
    public boolean isWordCorrect(String word, String definition) throws WordNotFoundException {
        log.debug(String.format("Checking if '%s' matches '%s'...", word, definition));
        Integer wordId = getWord(word).getWordId();
        List<Definition> lstDefinition = getWordDefinition(wordId).getListOfDefinitions();
        Stream<Definition> found = lstDefinition.stream().filter(
                x -> x.getMeaning().replaceAll("[^a-zA-Z0-9]", "")
                        .equalsIgnoreCase(definition.replaceAll("[^a-zA-Z0-9]", "")));
        if (found.findFirst().isPresent()) {
            log.debug(String.format("Word: '%s' is correct.", word));
            return true;
        } else {
            log.debug(String.format("Word: '%s' is correct.", word));
            return false;
        }
    }

    /**
     * Get a limited number of random words.
     *
     * @param limit the number of words to limit.
     * @return the limited number of random words.
     */
    public List<Word> getRandomWords(int limit) {
        return wordJdbc.findRandomLimit(Enabled.toInt(Enabled.TRUE), limit);
    }

    /**
     * Add new word.
     *
     * @param word the word.
     * @return the word.
     */
    public Word addWord(Word word) {
        return wordRepo.save(word);
    }

    /**
     * Add new word with its definitions.
     *
     * @param wordWithDefs the word with definitions.
     * @return true if added, otherwise - false.
     */
    public boolean addWordDefinition(WordWithDefinitions wordWithDefs) {
        //Store word
        Word word = addWord(wordWithDefs.getWord());
        wordWithDefs.setWord(word);

        for (Definition def : wordWithDefs.getListOfDefinitions()) {
            //Parts of speech
            def.setPos(posServ.getPartOfSpeech(def.getPos()));

            if (def.getPos() != null) {
                //Store definition
                Definition definition = defServ.addDefinition(def);
                WordDefinition wordDef = new WordDefinition(0, word, definition);
                WordDefinition saved = wordDefRepo.save(wordDef);
            } else {
                return false;
            }
        }
        return true;
    }

}
