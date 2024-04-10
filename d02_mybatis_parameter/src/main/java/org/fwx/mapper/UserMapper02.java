package org.fwx.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.fwx.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/8 14:09
 * @Version 1.0
 */
public interface UserMapper02 {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（以map集合作为参数）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录（以User为参数）
     * @param user
     * @return
     */
    User checkLoginByUser(User user);

    /**
     * 添加用户信息
     * useGeneratedKeys:表示当前添加功能使用自增的主键
     * keyProperty:将添加的数据的自增主键为实体类类型的参数的属性赋值
     * @param user
     */
    int insertUser(User user);

    /**
     * 验证登录（使用@Param）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 将数据封装到 Map 中
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    /**
     * 根据 name 模糊查询
     * @param name
     * @return
     */
    List<User> getUserByNameLike(@Param("username") String name);

    /**
     * 根据表名查询用户信息
     * @param tableName
     * @return
     */
    List<User> getDataFromTable(@Param("tableName") String tableName);
}
