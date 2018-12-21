package org.java.web;

import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(String name, String pwd, HttpSession session){
        Map user=userService.getUser(name, pwd);
        if(user!=null){
            session.setAttribute("user",user);
        }
        return "redirect:init";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:init";
    }
}
