package com.lindaring.guess.service;

import com.lindaring.guess.model.User;
import com.lindaring.guess.repository.UserRepo;
import com.lindaring.guess.utils.LoggingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServ {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LoggingUtil logUtil;

    /**
     * Add new user to the topscore list if the user with the same score does not exists.
     *
     * @param user the user.
     * @return the user.
     */
    public User addTopScore(User user) {
        List<User> userList = userRepo.findByNameAndScore(user.getName().toLowerCase(), user.getScore());
        User response = userList.isEmpty() ? userRepo.save(user) : new User(0);

        logUtil.logMethodDebug(getClass(), "addTopScore", response);
        return response;
    }

    /**
     * Get the list of users limited to the number specified.
     *
     * @param limit
     * @return
     */
    public List<User> getTopScore(int limit) {
        List<User> userList = new ArrayList<>();
        userRepo.findAllByOrderByScoreDesc().forEach(userList::add);

        List<User> response = userList.stream().limit(limit).collect(Collectors.toList());
        logUtil.logMethodDebug(getClass(), "getTopScore", response);
        return response;
    }

}
