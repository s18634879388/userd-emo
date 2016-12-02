package com.demo.service;

import com.demo.domain.UserDemo;
import com.demo.mapper.UserDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service
public class UserDemoService {
    @Autowired
    UserDemoMapper userDemoMapper;
    public void addUser(UserDemo userDemo){
        userDemoMapper.addUser(userDemo);
    }
}
