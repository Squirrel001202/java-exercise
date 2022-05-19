package org.example.service;

import org.example.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    业务逻辑层接口
 */
public interface UserService {
    //登录验证
    boolean selectUser(User user);
    //安全退出
    HttpServletResponse exit(HttpServletRequest request, HttpServletResponse response);
}
