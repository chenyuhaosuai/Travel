package Caculate;

import org.junit.Test;

import java.util.Arrays;

/*
* 位运输实现加减乘除
* */
public class test {

    public int add(int a, int b){
        if(b == 0){
            return a;
        }
        int carry = (a&b) << 1;  //表示进制位
        a = a^b;
        return add(a,carry);

    }

    public int sub(int a, int b){
        //获取补码
        b = ~b+1;

        //转成加法

        return add(a,b);
    }

    public int multi(int a, int b){

        int temp_a = Math.abs( a );
        int temp_b = Math.abs( b );
        int i=0;
        int res=0;
        //当乘数不为0
        while(temp_b != 0){
            if((temp_b & 1) == 1){
                res = res + (temp_a<<i);
                temp_b = temp_b>>1;
                i = i+1;
            }else{
                temp_b = temp_b>>1;
                i = i+1;
            }
        }
        if(a<0){
            res = res*(-1);
        }
        if(b<0){
            res = res*(-1);
        }
        return res;
    }

    public int division(int a, int b ){
        int tempa = Math.abs( a );
        int tempb = Math.abs( b );

        int res;
        if(tempa<tempb){
            res = 0;
        }else{
            res = division( sub( tempa,tempb ),tempb )+1;
        }
        if(a<0){
            res =res * -1;
        }
        if(b<0){
            res = res * -1;
        }
        return res;
    }


    public int new_sub(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return divisor;
        }
        int falg = 0;
        int res = 0;
        if(dividend >= 0){
            falg++;
            dividend = 0 - dividend;
        }
        if(divisor >= 0){
            falg++;
            divisor = 0 - divisor;
        }
        if(divisor<-1) {
            while (dividend <= divisor) {
                int temp = 1;
                int div = divisor;
                while(div >= dividend-div){
                    temp++;
                    div += div;
                }
                res = res + temp;
                dividend =dividend - div;
            }
        }else{
            res = 0 - dividend;
        }

        return  falg == 1 ? 0-res : res;
    }

    @Test
    public void test(){
//        int a =  1, b =2;

//        System.out.println( add( a,b ) );
////        System.out.println( sub( a,b ) );
////        System.out.println( multi( a,b ) );
//        System.out.println( new_sub( a,b ) );
        int[] nums = new int[]{1,1,2,2,3};
        nextPermutation( nums );
    }
    public static void  nextPermutation(int[] nums) {
      for(int i=0;i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++){
              if(nums[j-1]>nums[j]){
                  int temp = nums[j];
                  nums[j] = nums[j-1];
                  nums[j-1] = temp;
              }
          }
      }
      for(int i=0; i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                int j =i+1;
                while(j<nums.length-1){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    j= j+1;
                }
                nums[nums.length-1] = nums[i];
            }
        }
        for(int i=0; i<nums.length;i++){
            System.out.println( nums[i] );
        }

    }
}
