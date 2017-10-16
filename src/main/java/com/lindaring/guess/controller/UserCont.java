package com.lindaring.guess.controller;

import com.lindaring.guess.model.User;
import com.lindaring.guess.service.UserServ;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/guessword/v1/user")
public class UserCont {

    @Autowired
    UserServ userServ;

    @ApiOperation(notes="Get users with the highest scores", value="Get top score users")
    @RequestMapping(value="/topscore/{limit}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<User>> getTopScoreUsers(@ApiParam(value="Return maximum number of users", required=true) @PathVariable int limit) {
        List<User> userList = userServ.getTopScore(limit);
        return new ResponseEntity<>(userList, HttpStatus.FOUND);
    }
        
    @ApiOperation(notes="Add a user top-score list", value="Add top-score")
    @RequestMapping(value="/add", method=RequestMethod.POST, consumes = "application/json", produces="application/json")
    public ResponseEntity<Boolean> addTopScore(@ApiParam(value="User and score", required=true) @RequestBody User user) {
        User topScore = userServ.addTopScore(user);
        Boolean isAdded = (topScore.getUserId() == 0) || !StringUtils.isEmpty(topScore.getUserId());
        return new ResponseEntity<>(isAdded, HttpStatus.CREATED);
    }
}
