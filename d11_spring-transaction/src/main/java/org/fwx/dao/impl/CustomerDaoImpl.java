package org.fwx.dao.impl;

import org.fwx.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName CostomerDaoImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 14:46
 * @Version 1.0
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateCostomer(Integer id,Integer price) {
        String sql = "update t_customer set balance = balance - ? where user_id = ?";
        int i = jdbcTemplate.update(sql, price, id);
        System.out.println("update customer = " + i);
    }
}
