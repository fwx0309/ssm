package org.fwx.mapper;

import org.apache.ibatis.session.SqlSession;
import org.fwx.pojo.User;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapperTest
 * @Description
 * MyBatis获取参数值的两种方式：#{}和${}
 *  #{}的本质是占位符赋值，${}的本质是字符串拼接
 *  1、若mapper接口方法的参数为单个的字面量类型
 *  此时可以通过#{}和${}以任意的内容获取参数值，一定要注意${}的单引号问题
 *
 *  2、若mapper接口方法的参数为多个的字面量类型
 *  此时MyBatis会将参数放在map集合中，以两种方式存储数据
 *  a>以arg0,arg1...为键，以参数为值
 *  b>以param1,param2...为键，以参数为值
 *  因此，只需要通过#{}和${}访问map集合的键，就可以获取相对应的值,一定要注意${}的单引号问题
 *
 *  3、若mapper接口方法的参数为map集合类型的参数
 *  只需要通过#{}和${}访问map集合的键，就可以获取相对应的值,一定要注意${}的单引号问题
 *
 *  4、若mapper接口方法的参数为实体类类型的参数
 *  只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，一定要注意${}的单引号问题
 *
 *  5、可以在mapper接口方法的参数上设置@Param注解
 *  此时MyBatis会将这些参数放在map中，以两种方式进行存储
 *  a>以@Param注解的value属性值为键，以参数为值
 *  b>以param1,param2...为键，以参数为值
 *  只需要通过#{}和${}访问map集合的键，就可以获取相对应的值,一定要注意${}的单引号问题
 *
 * @Author Fwx
 * @Date 2024/4/8 14:13
 * @Version 1.0
 */
public class UserMapper02Test {

    /**
     * 根据用户名查询用户信息
     */
    @Test
    public void getUserByUsernameTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        User user = mapper.getUserByUsername("tom");
        System.out.println("user = " + user);
    }

    /**
     * 验证登录
     */
    @Test
    public void checkLoginTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        User user = mapper.checkLogin("admin","1234");
        System.out.println("user = " + user);
    }

    /**
     * 验证登录（以map集合作为参数）
     */
    @Test
    public void checkLoginByMapTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","1234");
        User user = mapper.checkLoginByMap(map);
        System.out.println("user = " + user);
    }

    /**
     * 验证登录（以User为参数）
     */
    @Test
    public void checkLoginByUserTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("1234");
        User user = mapper.checkLoginByUser(user1);
        System.out.println("user = " + user);
    }


    /**
     * 验证登录（使用@Param）
     */
    @Test
    public void checkLoginByParamTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        User user = mapper.checkLoginByParam("admin","1234");
        System.out.println("user = " + user);
    }

    /**
     * 将数据封装到 Map 中
     */
    @Test
    public void getAllUserToMapTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println("map = " + map);
    }

    /**
     * 根据 name 模糊查询
     */
    @Test
    public void getUserByNameLikeTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        List<User> o = mapper.getUserByNameLike("o");
        System.out.println("o = " + o);
    }

    /**
     * 根据表名查询用户信息
     */
    @Test
    public void getDataFromTableTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        List<User> t_user = mapper.getDataFromTable("t_user");
        System.out.println("t_user = " + t_user);
    }

    /**
     * 添加用户信息
     *  useGeneratedKeys:表示当前添加功能使用自增的主键
     *  keyProperty:将添加的数据的自增主键为实体类类型的参数的属性赋值
     */
    @Test
    public void insertUserTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper02 mapper = sqlsession.getMapper(UserMapper02.class);
        User user = new User(null, "xiaoming", "1234", 18, "男", "xiaoming@qq.com");
        int i = mapper.insertUser(user);
        System.out.println("i = " + i);
        System.out.println("user = " + user);
    }
}
