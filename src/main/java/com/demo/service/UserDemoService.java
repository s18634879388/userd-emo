package com.demo.service;

import com.demo.domain.LoginLog;
import com.demo.domain.UserDemo;
import com.demo.mapper.LoginLogMapper;
import com.demo.mapper.UserDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
@Service
public class UserDemoService {
    @Autowired
    UserDemoMapper userDemoMapper;
    @Autowired
    LoginLogMapper loginLogMapper;

    public void addUser(UserDemo userDemo){
        userDemoMapper.addUser(userDemo);
    }

    public int login(UserDemo userDemo) {
        UserDemo result = userDemoMapper.getUserByName(userDemo.getUserName());
        if (result==null){
            return -1;
        }else if (!(result.getPassword().equals(userDemo.getPassword()))){
            return 0;
        }else {
            LoginLog log = loginLogMapper.getLogById(result.getId());
            if (log==null){
                log = new LoginLog();
                log.setId(result.getId());
                log.setIsDelete(1);
                loginLogMapper.addLog(log);
            }else {
                loginLogMapper.updateLog(result.getId(),1);
            }
            return result.getId();
        }
    }

    public void logout(int id) {
        loginLogMapper.updateLog(id,0);
    }

    public List<UserDemo> allUser() {
       return userDemoMapper.allUser();
    }
}
