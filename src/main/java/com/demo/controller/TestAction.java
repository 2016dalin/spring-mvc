package com.demo.controller;

import com.demo.dao.TestDao;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2016/9/2.
 */

@EnableAutoConfiguration
@Controller
    @RequestMapping("/test")
public class TestAction {

    @Autowired
    private TestDao testDao;

    @RequestMapping("/index")
    @ResponseBody
    public Map<String, Object> index(String id,String memberId) {
        Map<String, Object> res = new HashMap<String, Object>();
        System.out.println(id + memberId);
        String sqls = "select * from ydb_member_checkin_log ";
        if (id != null && memberId != null){
            sqls += "where id = "+ id +" and member_id = '" + memberId + "'";
        }else {
            if (id != null){
                sqls += "where id = " + id;
            }
            if (memberId != null){
                sqls += "where member_id = '" + memberId + "'";
            }
        }
        System.out.println(sqls);
        List<Map<String, Object>> queryList = testDao.queryAll(sqls);
        res.put("success", true);
        res.put("data", queryList);
        return res;
    }


    public long chatge(String a,String b){
        long ch = 0;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sd.parse(a);
            Date d2 = sd.parse(b);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return ch;
    }


}
