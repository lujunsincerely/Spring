package com.twx.spring.service;

import com.twx.spring.model.User;

import java.util.List;

/**
 * Created by twx on 2017/6/27.
 */
public interface UserService {
    public void saveUsers(List<User> us);
    public List<User> getAllUsers();
}
