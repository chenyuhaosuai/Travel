package com.cuit.mappers;

import com.cuit.pojo.RouteImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Route_ImgMapper {
    public List<RouteImg> findByRid(@Param("rid") int rid);
}
