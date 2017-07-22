package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by twx on 2017/3/18.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        System.out.println("home");
        model.addAttribute("aaa","something");
        return "home";
    }

   /* @RequestMapping(value = "/receive",method = RequestMethod.POST)
    public String test(String username){
        System.out.println("usrname: "+username);
        return "home";
    }*/

    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    public String saveTestFile(@RequestParam("file") MultipartFile file) {
        String name = file.getOriginalFilename();
        System.out.println("name:"+name+"size "+file.getSize());
        try {
            file.transferTo(new File("D:/"+name));
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "home";
    }
}
