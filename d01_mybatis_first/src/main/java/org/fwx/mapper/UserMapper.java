package org.fwx.mapper;

import org.fwx.pojo.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/7 15:05
 * @Version 1.0
 */
public interface UserMapper {

    public int insertUser();

    public int updateUser();

    public int deteleOne();

    public User selectOne();

    public List<User> selectAll();
}
