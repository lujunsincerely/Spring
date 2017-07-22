package com.twx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by twx on 2017/3/19.
 */
@Controller
@RequestMapping("/")
public class HelloController {
    private Map<String, Integer> map = new HashMap<>();
    private int testSingle = 777;

    public HelloController() {
        System.out.println("controller....");
    }

    @RequestMapping( method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        System.out.println("hello");
        model.addAttribute("message", "Hello, Welcom !");
        return "hello";
    }

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    @ResponseBody
    public String getOne() {
        if (map.get("id") == null) {
            for (int i = 0; i <=1000; i++) {
                map.put("id",i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("getOne() num is ");
            return "OK";
        }
        return "wait...";
    }
    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    @ResponseBody
    public String getTwo() {
        if (map.get("id") != null) {
            int percent = map.get("id");
            if (percent == 1000) {
                map.remove("id");
            }
            System.out.println("getTwo() num "+percent);
            return String.valueOf(percent);
        }
        return "0";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestParam(value = "file") CommonsMultipartFile file) {

        System.out.println("test");
        System.out.println(file.getOriginalFilename());
        return "OK";
    }
}
