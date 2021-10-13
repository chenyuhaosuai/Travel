package com.cuit.mappers;

import com.cuit.pojo.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerMapper {

    public Seller findByid(@Param("id") int id);
}
