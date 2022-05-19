package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    控制层
 */
@Controller
public class UserController {
    //业务逻辑层对象
    @Autowired
    UserService userService;
    //登录
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, String f, HttpServletResponse response,HttpServletRequest request){
        User user = new User(username,password);
        boolean login = userService.selectUser(user);
        if(login){
            //登录成功
            if("1".equals(f)){
                //如果用户选择了十天免登录，新建cookie
                Cookie cookieUsername = new Cookie("username",username);
                Cookie cookiePassword = new Cookie("password", password);
                //设置10天有效期
                cookieUsername.setMaxAge(60 * 60 * 24 * 10);
                cookiePassword.setMaxAge(60 * 60 * 24 * 10);
                //绑定路径
                cookieUsername.setPath(request.getContextPath());
                cookiePassword.setPath(request.getContextPath());
                //响应Cookie给浏览器
                response.addCookie(cookieUsername);
                response.addCookie(cookiePassword);
            }
            session.setAttribute("username",username);
            return "redirect:/selectStudent";
        }else{
            //登录失败
            return "error";
        }
    }
    //安全退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request,HttpServletResponse response){
        HttpServletResponse servletResponse = userService.exit(request, response);
        return "redirect:/welcome";
    }
}
