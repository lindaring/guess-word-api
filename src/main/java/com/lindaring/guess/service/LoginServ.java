package com.lindaring.guess.service;

import com.lindaring.guess.model.Login;
import com.lindaring.guess.repository.LoginRepo;
import com.lindaring.guess.utils.DateUtils;
import com.lindaring.guess.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class LoginServ {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    DateUtils dateUtils;

    @Autowired
    LoggingUtil logUtil;

    /**
     * Insert ip address in the database.
     *
     * @param ipAddress the ip address.
     * @return true is the ip was recorded, otherwise - false.
     */
    public boolean recordIP(String ipAddress) {
        Login login = new Login(0, ipAddress, new Timestamp(System.currentTimeMillis()));
        Login added = loginRepo.save(login);

        logUtil.logMethodDebug(getClass(), "recordIP", added);
        return (added.getLoginId() > 0);
    }

}
