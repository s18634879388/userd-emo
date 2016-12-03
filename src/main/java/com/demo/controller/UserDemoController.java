package com.demo.controller;

import com.demo.domain.UserDemo;
import com.demo.service.UserDemoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/12/2.
 */
@Controller
@Api(basePath = "/users", value = "用户中心", description = "用户中心", produces = "application/json")
@RequestMapping("/users")
public class UserDemoController {
    @Autowired
    UserDemoService userDemoService;

    @ApiOperation(value = "注册", notes = "注册", position = 1)
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public UserDemo regist(@RequestBody UserDemo userDemo){
        userDemoService.addUser(userDemo);
        return userDemo;
    }
}
