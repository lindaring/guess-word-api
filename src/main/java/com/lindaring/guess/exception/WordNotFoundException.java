package com.lindaring.guess.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class WordNotFoundException extends Exception {

    public WordNotFoundException() {
        super("Word not found.");
    }

    public WordNotFoundException(String word) {
        super(word + " not found.");
    }

}
