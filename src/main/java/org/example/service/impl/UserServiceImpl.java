package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    业务逻辑层实现类
 */
@Service
public class UserServiceImpl implements UserService {
    //数据访问层对象
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean selectUser(User user) {
       if(userMapper.selectUser(user) == null){
           //查询结果为空，登录失败，返回false
           return false;
       }else {
           //查到用户，登录成功，返回true;
           return true;
       }
    }

    @Override
    public HttpServletResponse exit(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            //销毁session
            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    //销毁cookie
                    cookie.setMaxAge(0);
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
            }
        }
        return response;
    }
}
