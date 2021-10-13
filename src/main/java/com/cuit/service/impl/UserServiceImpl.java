package com.cuit.service.impl;

import com.cuit.mappers.UserMapper;
import com.cuit.pojo.ResultInfo;
import com.cuit.pojo.User;
import com.cuit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void test() {
        List<User> userList = userMapper.findAll();
        System.out.println(userList.size());
    }

    @Override
    public ResultInfo save(User user) {
        int num = userMapper.save(user);
        ResultInfo resultInfo = new ResultInfo();
        if(num == 1){
            resultInfo.setFlag(true);
        }
        else{
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo login(User user, HttpServletRequest request) {
        User userByNameAndPassword = userMapper.findUserByNameAndPassword(user);
        ResultInfo resultInfo = new ResultInfo();
        if(userByNameAndPassword == null){
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码");
        }else{
            resultInfo.setFlag(true);
            request.getSession().setAttribute("login_user",userByNameAndPassword);
        }
        return resultInfo;
    }
}
