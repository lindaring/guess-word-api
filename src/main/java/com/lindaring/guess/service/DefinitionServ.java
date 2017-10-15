package com.lindaring.guess.service;

import com.lindaring.guess.model.Definition;
import com.lindaring.guess.repository.DefinitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefinitionServ {

    @Autowired
    DefinitionRepo defRepo;

    /**
     * Add a new definition.
     *
     * @param definition the definition.
     * @return the definition.
     */
    public Definition addDefinition(Definition definition) {
        return defRepo.save(definition);
    }

}
