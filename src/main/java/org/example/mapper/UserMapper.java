package org.example.mapper;

import org.example.pojo.User;
/*
    数据访问层
 */
public interface UserMapper {
    //登录验证
    User selectUser(User user);
}
