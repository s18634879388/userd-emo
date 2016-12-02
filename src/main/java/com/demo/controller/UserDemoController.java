package com.demo.controller;

import com.demo.domain.UserDemo;
import com.demo.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/12/2.
 */
@Controller
public class UserDemoController {
    @Autowired
    UserDemoService userDemoService;


    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public String regist(@RequestBody UserDemo userDemo){
        userDemoService.addUser(userDemo);
        return "ok";
    }
}
