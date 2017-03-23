package com.test;

import sun.dc.pr.PRError;

import java.util.*;

/**
 * Created by xiaolinzi on 2016/10/19.
 */
public class test2 {
    //        public static Boolean valueOf(Boolean b){
//            return b ? Boolean.TRUE :Boolean.FALSE;
//        }
    //能定义成静态常量的尽量别吵吵
    private static final Date birthDate = null;
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBommerStaticFinal(){
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) > 0;
    }

    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    //类型错误执行时间翻翻倍
    public static void main(String[] ary){
        long suml = 0L;
        Long sumL = 0L;
//        for (long i = 0; i < Integer.MAX_VALUE; i++){
//            suml += i;
//            sumL += i;
//        }
//        System.out.println(suml);
//        System.out.println(sumL);
        float a = 1;
        float a1 = 10;
        Double b = 1.0;
        Double b1 = 1.0;

        System.out.println(Float.compare(a,a1));
        System.out.println(Double.compare(b,b1));
        System.out.println("如果值相等打印0.否则打印-1");
        //复制
//        x.clone();
        ary[0] = "1";
        ary[1] = "2";
        ary[2] = "3";
        ary[3] = "4";
        Set<String > s = new TreeSet<String>();
        Collections.addAll(s,ary);
        System.out.println(s);

    }


    public String ret (){
        int result = 17;
        int c = 0;
//        result = 31* result +areaCode;
//        return result = 31 * result +c;
        return  "";
    }

}
