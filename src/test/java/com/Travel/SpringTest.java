package com.Travel;

import com.cuit.controller.UserController;
import com.cuit.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationcontext.xml")
public class SpringTest {

    @Autowired
   private UserService userService;

//    @Autowired
//    private UserController userController;

    @Test
    public void test(){
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        UserService userService = app.getBean(UserService.class);
        userService.test();
    }

//    @Test
//    public void test1(){
//        userController.test();
//    }
    @Test
    public void get(){
        URL url = Filter.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println("path:"+url.getPath()+" name:"+url.getFile());
}
}
