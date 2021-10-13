package com.cuit.controller;

import com.cuit.pojo.Category;
import com.cuit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> findAll(){
        List<Category> categoryList = categoryService.findAll();
        return  categoryList;
    }
}
