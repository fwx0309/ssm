package org.fwx.dao;

/**
 * @ClassName BookDao
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/12 14:44
 * @Version 1.0
 */
public interface BookDao {

    void updateBook(Integer id);

    int getPrice(Integer id);
}
