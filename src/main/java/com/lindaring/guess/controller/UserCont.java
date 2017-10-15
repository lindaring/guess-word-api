package com.lindaring.guess.controller;

import com.lindaring.guess.exception.NoImplementationException;
import com.lindaring.guess.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/guessword/v1/user")
public class UserCont {
    
    @ApiOperation(notes="Get users with the highest scores", value="Get top score users")
    @RequestMapping(value="/topscore/{limit}", method=RequestMethod.GET)
    public List<User> getTopScoreUsers(
            @ApiParam(value="Return maximum number of users", required=true) @PathVariable int limit) 
            throws NoImplementationException {
        throw new NoImplementationException();
    }
        
    @ApiOperation(notes="Add a user top-score list", value="Add top-score")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public int addTopScore(
            @ApiParam(value="User and score", required=true) @RequestBody User word) 
            throws NoImplementationException {
        throw new NoImplementationException();
    }
}
