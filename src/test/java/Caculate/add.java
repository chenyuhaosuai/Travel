package Caculate;


import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;


public class add {

    @Test
    public void test(){
        /*
        * StringBUlider api方法的参数
        *
        * */
        StringBuilder sb = new StringBuilder("test");
//        sb = sb.reverse();
        sb.replace(1,3,"cy");
        sb.append( "aaa" ).append( "c" );
//        sb.setCharAt( 0,'c');
//        sb.insert( 1,'c' );
//        sb.delete( 1,3 );
        System.out.println(sb.toString());

    }

    @Test
    public void test1(){
        /*
        * 测试字符串
        * */
        String a = "aaaa";
        String b = new String("aaaa");
        System.out.println(a.length());
        System.out.println(a.contains("a"));
        System.out.println(a.replace("a","b"));
        System.out.println(a.charAt(1));
        System.out.println(a.indexOf('a'));
        System.out.println(a.replaceAll( "a","c" ));
        System.out.println(a.toCharArray());
        System.out.println(a.substring(1,3));
        System.out.println( a.equals( b ) );
        System.out.println(a.toUpperCase());
    }


    @Test
    public void test3(){
        int[] array = new int[]{1,2,3,5,4};
//        Arrays.sort( array );
        String b = Arrays.toString( array );
        String c =  b.replace( "1","c" );
        System.out.println( c );
    }

    @Test
    public void test4(){
        /*
        * 遍历set
        * */
        Set set = new HashSet(  );
        set.add( "a" );
        set.add( 1 );
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println( iterator.next() );
        }
        for(Object o : set){
            System.out.println( o );
        }
    }

    @Test
    public void test5(){
        /*
        * 遍历map
        * */
        Map map = new HashMap( );
        map.put( "name","cy" );

        map.put("age",24);
        Set<Map.Entry> set = map.entrySet();
        for(Map.Entry e:set){
            System.out.println( e.getKey()+"+"+e.getValue() );
        }
//        Set keys = map.keySet();
//        for(Object key:keys){
//            System.out.println( "key:"+key+","+"values:"+map.get(key) );
//        }
//        Iterator<Map.Entry> iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println( iterator.next() );
//        }

    }


}
