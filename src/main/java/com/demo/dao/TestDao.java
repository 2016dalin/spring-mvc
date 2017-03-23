package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2016/9/2.
 */
@Component
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> queryAll(String sqls) {
        return jdbcTemplate.queryForList(sqls);
    }

}
