package com.demo.controller;

import com.demo.domain.UserDemo;
import com.demo.service.UserDemoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
@Controller
@Api(basePath = "/users", value = "用户中心", description = "用户中心", produces = "application/json")
@RequestMapping("/users")
public class UserDemoController {
    @Autowired
    UserDemoService userDemoService;

    @ApiOperation(value = "注册", notes = "注册")
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public UserDemo regist(@RequestBody UserDemo userDemo){
        userDemoService.addUser(userDemo);
        return userDemo;
    }

    @ApiOperation(value = "登录",notes = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UserDemo userDemo){
        int res = userDemoService.login(userDemo);
        if (res == -1){
            return "用户不存在";
        }else if (res == 0){
            return "密码错误";
        } else {
            return "welcome--->"+userDemo.getUserName();
        }
    }

    @ApiOperation(value = "登出",notes = "登出")
    @RequestMapping(value = "/login/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String logout(
            @ApiParam(value = "用户id")
            @PathVariable("id") int id){
        userDemoService.logout(id);
        return "成功退出";
    }

    @ApiOperation(value = "获取所有用户",notes = "获取所有用户")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public List<UserDemo> allUser(){
        List<UserDemo> userDemos = userDemoService.allUser();
        return userDemos;
    }

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String login(){
        return "regist";
    }
    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String tologin(@ModelAttribute UserDemo userDemo,Model model){
        int res = userDemoService.login(userDemo);
        String message1 = "";
        if (res == -1){
            message1 = "用户不存在";
            model.addAttribute("message1",message1);
            return "error";
        }else if (res == 0){
            message1 = "密码错误";
            model.addAttribute("message1",message1);
            return "error";
        } else {
            message1 = "welcome--->"+userDemo.getUserName();
            model.addAttribute("message1",message1);
            return "ok";
        }
    }
}
