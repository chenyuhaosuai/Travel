package com.cuit.service;

import com.cuit.pojo.ResultInfo;
import com.cuit.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public void test();

    public ResultInfo save(User user);

    ResultInfo login(User user,HttpServletRequest request);

}
