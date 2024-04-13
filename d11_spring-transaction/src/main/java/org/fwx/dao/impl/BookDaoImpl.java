package org.fwx.dao.impl;

import org.fwx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 14:51
 * @Version 1.0
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateBook(Integer id) {
        String sql = "update t_book set stock = stock-1 where book_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("update book = " + update);
    }

    @Override
    public int getPrice(Integer id) {
        String sql = "select price from t_book where book_id=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return price;
    }
}
