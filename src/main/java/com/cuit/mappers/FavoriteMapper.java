package com.cuit.mappers;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FavoriteMapper {

    int findByRidAndUid(@Param("rid")int rid, @Param("uid")int uid);

    void add(@Param("rid") int rid, @Param("date") Date date, @Param("uid") int uid);
}
