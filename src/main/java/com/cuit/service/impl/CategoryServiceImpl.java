package com.cuit.service.impl;

import com.cuit.mappers.CategoryMapper;
import com.cuit.pojo.Category;
import com.cuit.service.CategoryService;
import com.cuit.utils.JedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        /*
        * 1.每次应该先到redis中去查询，有数据就直接返回
        * 2.如果没有数据，先到mysql数据库中查询
        * 3.在存储到redis中(做缓存机制)
        * */
        List<Category> categoryList = new ArrayList<Category>();
        ObjectMapper objectMapper = new ObjectMapper();
        Jedis jedis = JedisUtils.getJedis();
        String cateGory = jedis.get("categoryList");
        if(cateGory == null || cateGory.length() == 0){
            categoryList  = categoryMapper.findAll();
            try {
                jedis.set("categoryList",objectMapper.writeValueAsString(categoryList));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else {
            try {
                categoryList=objectMapper.readValue(cateGory,new TypeReference<List<Category>>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(categoryList);
        JedisUtils.retrunJedis(jedis);
        return categoryList;
    }
}
