package com.cuit.controller;

import com.cuit.pojo.PageBean;
import com.cuit.pojo.Route;
import com.cuit.pojo.User;
import com.cuit.service.RouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/route")
public class RouteController {
    @Autowired
    private RouteService routeService;


    @RequestMapping(value = "/AddFavorites", method = RequestMethod.GET)
    public void AddFavorites(HttpServletRequest request){
        String StrRid = request.getParameter("rid");
        int rid = Integer.parseInt(StrRid);
        User user = (User) request.getSession().getAttribute("login_user");
        int uid = user.getUid();
        routeService.saveFavorite(rid,uid);
    }

    @RequestMapping(value = "/isFavorites", method = RequestMethod.GET)
    public void isFavorites(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String strRid = request.getParameter("rid");
        int rid = Integer.parseInt(strRid);
        User user = (User) request.getSession().getAttribute("login_user");
        int uid;
        if(user == null){
            uid = -1;
        }else{
            uid = user.getUid();
        }
        Boolean flag = routeService.isFavorites(rid, uid);
        ObjectMapper objectMapper = new ObjectMapper();
        String json_flag = objectMapper.writeValueAsString(flag);
        response.setContentType("application/json; charset=utf-8");
        response.getOutputStream().print(json_flag);
    }


    @RequestMapping(value="/findDetail",method = RequestMethod.GET)
    @ResponseBody
    public Route findDetail(HttpServletRequest request){
        String rid = request.getParameter("rid");
        Route route = routeService.findDetail(Integer.parseInt(rid));
        return route;
    }

    @RequestMapping(value = "/findByCid",method = RequestMethod.GET)
    @ResponseBody
    public PageBean findByCid(HttpServletRequest request) throws UnsupportedEncodingException {

        PageBean pageBean = new PageBean();
        String strcid = request.getParameter("cid");
        String strcurrentPage = request.getParameter("currentPage");
        String strpagetotal = request.getParameter("pagetotal");

        String rname =request.getParameter("rname");

        if(("null").equals(rname)){
            rname = null;
        }
        if(rname != null) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }



        int cid = 0;
        if(strcid == null || strcid.length() <= 0 || ("null").equals(strcid)){
            cid = 0;
        }else{
            cid = Integer.parseInt(strcid);
        }
        int currentPage = 0;
        if(strcurrentPage == null || strcurrentPage.length()<=0){
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(strcurrentPage);
        }
        int pagetotal = 0;
        if(strpagetotal == null || strpagetotal.length()<=0){
            pagetotal = 5;
        }else {
            pagetotal = Integer.parseInt(strpagetotal);
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setPagetotal(pagetotal);
        PageBean serviceByCid = routeService.findByCid(cid, pageBean,rname);
        return serviceByCid;
    }
}
