package com.twx.spring.mvc;

import com.twx.spring.model.User;
import com.twx.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twx on 2017/6/27.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        List<User> us = new ArrayList<User>();
        User u = new User();
        u.setId(1);
        u.setUsername("zhangsan");
        us.add(u);
        u = new User();
        u.setId(2);
        u.setUsername("wangwu");
        us.add(u);
        System.out.println("*************");
        userService.saveUsers(us);
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> json(){
        return userService.getAllUsers();
    }
}
