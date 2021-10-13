package com.Travel;

import com.cuit.pojo.PageBean;
import com.cuit.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
public class dividePage {
    @Autowired
    private RouteService routeService;
    @Test
    public void test(){
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(1);
        pageBean.setPagetotal(5);
        routeService.findByCid(5, pageBean,"西安");

    }
    @Test
    public void test1() {
        routeService.findDetail(234);
    }



}
