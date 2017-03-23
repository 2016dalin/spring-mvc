package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by xiaolinzi on 2016/10/19.
 */
@RestController //比Controller注解多的功能就是给底下的RequestMapping方法默认都加上ResponseBody注解
@Configuration //spring的配置类，本身自带Component注解
@ImportResource //对应的xml<import resource="applicationContext-ehcache.xml"/>
@ComponentScan //对应的xml<context:component-scan base-package="com.xixicat.app"/>
                //该配置自动包含了如下配置的功能：<context:annotation-config/>
                //就是向Spring容器注册AutowiredAnnotationBeanPostProcessor( 使用@Autowired必须注册 )、CommonAnnotationBeanPostProcessor( 使用@Resource 、@PostConstruct、@PreDestroy等必须注册 )、PersistenceAnnotationBeanPostProcessor( 使用@PersistenceContext必须注册 ) 以及RequiredAnnotationBeanPostProcessor( 使用@Required必须注册 )这4个BeanPostProcessor。
                //值得注意的是 Spring3.1RC2版本 是不允许注解Configuration的类在ComponentScan指定的包范围内的，否则会报错。
//@Bean 对应的xml如下：<bean id="objectMapper" class="org.codehaus.jackson.map.ObjectMapper" />
@ResponseStatus //主要是rest开发用，注解返回的http返回码，具体值看org.springframework.http.HttpStatus枚举。一般 post方法返回HttpStatus.CREATED，DELETE和PUT方法返回HttpStatus.OK。还可以配置异常处理，见 @ExceptionHandler和@ControllerAdvice
//@ExceptionHandler 主要用来处理指定的异常，返回返回指定的HTTP状态码，省得每个controller的方法自己去try catch。一般可以为每个应用定义一个异常基类，然后再定义业务异常，这样这里就可以统一捕获业务异常。
@ControllerAdvice   //配合@ExceptionHandler使用的，用来拦截controller的方法。

public class test1 {
        public static final int N = 50000;
        public static List values;
        static {
            Integer vals[] = new Integer[N];
            Random r = new Random();
            for (int i = 0, currval = 0; i < N; i++) {
                vals[i] = new Integer(currval);
                currval += r.nextInt(100) + 1;
            }
            values = Arrays.asList(vals);
        }
        static long timeList(List lst) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < N; i++) {
                int index = Collections.binarySearch(lst, values.get(i));
                if (index != i)
                    System.out.println("***错误***");
            }
            return System.currentTimeMillis() - start;
        }
        public static void main(String args[]) {
            System.out.println("ArrayList消耗时间：" +values+ timeList(new ArrayList(values)));
            System.out.println("LinkedList消耗时间：" + timeList(new LinkedList(values)));


            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("cn", "中国");
            hashMap.put("us", "米国");
            hashMap.put("en", "英国");
            hashMap.put("","");

            System.out.println(hashMap);
            System.out.println("cn" + hashMap.get("cn"));
            System.out.println(hashMap.containsKey("cn"));
            System.out.println(hashMap.keySet());
            System.out.println(hashMap.isEmpty());

            Hashtable table = new Hashtable();
            table.put("key1", "value1");//键 和 值,
            table.put("key2", "value2");
            table.put("key3", "value3");//相当于堆栈 后进先出

            Enumeration e = table.keys();//创建枚举
            while (e.hasMoreElements()) {//是否有元素
                String key = (String) e.nextElement();
                System.out.println(key + " : " + table.get(key));
            }
        }
}
