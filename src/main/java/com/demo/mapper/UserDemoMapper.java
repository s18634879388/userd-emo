package com.demo.mapper;

import com.demo.domain.UserDemo;

/**
 * Created by Administrator on 2016/12/2.
 */
public interface UserDemoMapper {
    void addUser(UserDemo userDemo);
    UserDemo getUserByName(String userName);
}
