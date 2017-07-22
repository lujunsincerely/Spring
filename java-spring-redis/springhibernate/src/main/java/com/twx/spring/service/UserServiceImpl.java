package com.twx.spring.service;

import com.twx.spring.dao.UserDAO;
import com.twx.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twx on 2017/6/27.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public void saveUsers(List<User> us) {
        for (User u : us) {
            userDAO.save(u);
        }
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
