package com.lindaring.guess.controller;

import com.lindaring.guess.service.LoginServ;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/guessword/v1/login")
public class LoginCont {

    @Autowired
    LoginServ loginServ;

    @ApiOperation(notes="Record ip address", value="record ip address")
    @RequestMapping(value="/{ip:.+}", method=RequestMethod.POST, produces="application/json")
    public ResponseEntity<Boolean> recordIP(@ApiParam(value="Ip address", required=true) @PathVariable String ip)  {
        Boolean isRecorded = loginServ.recordIP(ip);
        return new ResponseEntity<>(isRecorded, HttpStatus.CREATED);
    }

}
