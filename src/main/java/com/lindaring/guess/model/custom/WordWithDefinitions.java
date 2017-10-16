package com.lindaring.guess.model.custom;

import com.lindaring.guess.model.Definition;
import com.lindaring.guess.model.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
