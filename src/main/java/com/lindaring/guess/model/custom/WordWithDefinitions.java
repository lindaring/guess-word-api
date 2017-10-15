package com.lindaring.guess.model.custom;

import com.lindaring.guess.model.Definition;
import com.lindaring.guess.model.Word;
import java.util.List;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class WordWithDefinitions {
    
    private Word word;
    private List<Definition> listOfDefinitions;
    
}
