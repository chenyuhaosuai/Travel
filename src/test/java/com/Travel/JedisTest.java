package com.Travel;

import com.cuit.utils.JedisUtils;
import org.junit.Test;

public class JedisTest {

    @Test
    public void test(){
       System.out.println(JedisUtils.getJedis());
    }
}
