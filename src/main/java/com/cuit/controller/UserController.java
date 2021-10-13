package com.cuit.controller;

import com.cuit.pojo.ResultInfo;
import com.cuit.pojo.User;
import com.cuit.pojo.User_1;
import com.cuit.service.UserService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public void test(@RequestBody(required = false) User_1 user1,HttpServletRequest request){
       System.out.println(request.getParameter("name"));
        System.out.println(user1);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo Register(@RequestBody User user){
        ResultInfo resultInfo = userService.save(user);
        return resultInfo;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo login(@RequestBody User user,HttpServletRequest request){
        ResultInfo resultInfo = userService.login(user,request);
        return resultInfo;
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    @ResponseBody
    public User findUser(HttpServletRequest request){
        User login_user = (User)request.getSession().getAttribute("login_user");
//        System.out.println(login_user);
        return login_user;
    }

    @RequestMapping(value = "/out")
    public String out(HttpServletRequest request){
       request.getSession().invalidate();
       return "redirect:"+request.getContextPath()+"/pages/login.html";

    }

}
