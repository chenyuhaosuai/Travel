package com.cuit.mappers;

import com.cuit.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    public List<Category> findAll();
}
