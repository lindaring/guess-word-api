package com.lindaring.guess.controller;

import com.lindaring.guess.exception.NoImplementationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/guessword/v1/login")
public class LoginCont {
            
    @ApiOperation(notes="Record ip address", value="record ip address")
    @RequestMapping(value="/{ip}", method=RequestMethod.POST)
    public int recordIP(
            @ApiParam(value="Ip address", required=true) @PathVariable String ip) 
            throws NoImplementationException {
        throw new NoImplementationException();
    }
    
}
