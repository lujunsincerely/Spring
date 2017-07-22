package com.twx.spring.dao;

import com.twx.spring.model.User;

import java.util.List;

/**
 * Created by twx on 2017/6/27.
 */
public interface UserDAO {
    public int save(User u);
    public List<User> findAll();
}
