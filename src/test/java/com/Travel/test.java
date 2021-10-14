package com.Travel;

import java.util.*;

public class test {
    public static void main(String[] args) {

        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

        StringBuffer s = new StringBuffer( "abcd");

        List list = new ArrayList(  );
        list.add( 1 );
        
        System.out.println( list);
        System.out.println( "101" );


    }

    public static int removeDuplicates(int[] nums) {
        int ans = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] ==nums[j]){

                    nums[j] = Integer.MAX_VALUE;
                }
            }
        }
        Arrays.sort( nums );
        for(int i= 0; i<nums.length; i++){
           if(nums[i] != Integer.MAX_VALUE){
               ans++;
           }
        }
        return ans;
    }

}









