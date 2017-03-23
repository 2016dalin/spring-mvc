package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lenovo on 2016/9/2.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

//        String a = "看你";
//        String b = new String();
//        if ((a != "" && a != null) && (b != "" && b != null)){
//            System.out.println("行的通");
//            System.out.println(a + b);
//
//        }
//        if (a != ""){
//            System.out.println("不等于双引号");
//        }
//        if (a != null){
//            System.out.println("不等于NUll");
//        }
//        if (!"".equals(a)){
//            System.out.println("不等于!双引号");
//        }
//        int i = 12;
//        System.out.println(i += i -= i *= i);
        int a = 1100;
        int b = 100;
        int c = a % b;
        System.out.println(c);
//        int p = 1;
//        for (int i =0; i<10; i++) {
//            if (i==p){
//                System.out.println(i);
//            }
//            if (i == 2){
//                System.out.println(123);
//            }
//        }
    }

}
