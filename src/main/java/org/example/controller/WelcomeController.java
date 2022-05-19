package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    首页控制
 */
@Controller
public class WelcomeController {
    //业务逻辑层对象
    @Autowired
    UserService userService;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request, HttpSession session){
        //获取所有Cookie
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if(cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("username".equals(name)) {
                    username = cookie.getValue();
                } else if ("password".equals(name)) {
                    password = cookie.getValue();
                }
            }
        }
        if(username != null && password != null){
            User user = new User(username, password);
            if(userService.selectUser(user)){
                session.setAttribute("username",username);
                return "redirect:/selectStudent";
            }else{
                return "index";
            }
        }
        return "index";
    }
}
