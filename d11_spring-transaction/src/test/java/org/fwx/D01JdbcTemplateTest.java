package org.fwx;

import org.fwx.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName D01JdbcTemplate
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 12:22
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class D01JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTemplate(){
        String sql = "insert into t_user (username,password,age,gender,email) values (?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, "小天", "1234", 18, "男", "xiaotian@qq.com");
        System.out.println("i = " + i);
    }

    @Test
    public void jdbcTemplate1(){
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println("user = " + user);
    }

    @Test
    public void jdbcTemplate2(){
        String sql = "select * from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println("userList = " + userList);
    }

    @Test
    public void jdbcTemplate3(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);

    }
}
