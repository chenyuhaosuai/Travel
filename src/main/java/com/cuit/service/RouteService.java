package com.cuit.service;

import com.cuit.pojo.PageBean;
import com.cuit.pojo.Route;

public interface RouteService {
    public PageBean findByCid(int cid, PageBean pageBean,String rname);

    Route findDetail(int rid);

    Boolean isFavorites(int rid, int uid);

    void saveFavorite(int rid, int uid);
}
