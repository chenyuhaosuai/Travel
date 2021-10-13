package com.cuit.service.impl;

import com.cuit.mappers.FavoriteMapper;
import com.cuit.mappers.RouteMapper;
import com.cuit.mappers.Route_ImgMapper;
import com.cuit.mappers.SellerMapper;
import com.cuit.pojo.PageBean;
import com.cuit.pojo.Route;
import com.cuit.pojo.RouteImg;
import com.cuit.pojo.Seller;
import com.cuit.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private Route_ImgMapper route_imgMapper;

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public PageBean findByCid(int cid, PageBean pageBean,String rname) {
        PageBean p1 = new PageBean();
        int totall = routeMapper.getTotall(cid,rname);
//        System.out.println(totall);
        p1.setTotal(totall);
        int start = (pageBean.getCurrentPage()-1)*pageBean.getPagetotal();
        List<Route> routeList = routeMapper.findRouteByCid(cid, start, pageBean.getPagetotal(),rname);
        if(totall% pageBean.getPagetotal() ==0){
            p1.setPages((totall/pageBean.getPagetotal()));
        }else {
            p1.setPages((totall/pageBean.getPagetotal())+1);
        }
        p1.setCurrentPage(pageBean.getCurrentPage());
        p1.setPagetotal(pageBean.getPagetotal());
        p1.setRouteList(routeList);
//        System.out.println(routeList);
//        System.out.println(totall);
        return p1;
    }

    @Override
    public Route findDetail(int rid) {
        Route routeByRid = routeMapper.findRouteByRid(rid);
        List<RouteImg> routeImgList = route_imgMapper.findByRid(rid);
        routeByRid.setRouteImgList(routeImgList);
        Seller seller = sellerMapper.findByid(routeByRid.getSid());
        routeByRid.setSeller(seller);
        return routeByRid;
    }

    @Override
    public Boolean isFavorites(int rid, int uid) {
        int byRidAndUid = favoriteMapper.findByRidAndUid(rid, uid);
        Boolean flag;
        if(byRidAndUid == 0){
            flag = false;
        }else {
            flag = true;
        }
        return flag;
    }

    @Override
    @Transactional
    public void saveFavorite(int rid, int uid) {

        favoriteMapper.add(rid,new Date(),uid);
        routeMapper.updateCount(rid);
    }
}
