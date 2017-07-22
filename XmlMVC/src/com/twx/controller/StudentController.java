package com.twx.controller;

import com.twx.beans.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by twx on 2017/3/19.
 */
@Controller
public class StudentController {
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String student(Model model){
        model.addAttribute("student",new Student());
        return "student";
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(@Valid Student student, Errors errors, ModelMap model){
        if (errors.hasErrors()) {
            return "student";
        }
        model.addAttribute(student);
        return "result";
    }
}
