package com.cuit.mappers;

import com.cuit.pojo.Route;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteMapper {
    public int getTotall(@Param("cid") int cid,@Param("rname") String rname);

    public List<Route> findRouteByCid(@Param("cid") int cid, @Param("start") int start, @Param("pagetotals") int pagetotals, @Param("rname") String rname);

    public Route findRouteByRid(@Param("rid") int rid);

    void updateCount(@Param("rid") int rid);
}
