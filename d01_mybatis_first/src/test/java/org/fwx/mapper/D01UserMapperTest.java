package org.fwx.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fwx.pojo.User;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/7 15:22
 * @Version 1.0
 */
public class D01UserMapperTest {
    /**
     * 插入数据测试
     * @throws IOException
     */
    @Test
    public void insertTest() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(new FileInputStream(Resources.getResourceAsFile("mybatis-config.xml")));

        // openSession(true) 开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 方式一
        // UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // int i = userMapper.insertUser();

        // 方式二
        int i = sqlSession.insert("org.fwx.mapper.UserMapper.insertUser");

        System.out.println("i = " + i);

        // sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 更新数据
     */
    @Test
    public void update(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.updateUser();
        System.out.println("i = " + i);
        sqlsession.close();
    }

    /**
     * 删除数据
     */
    @Test
    public void detele(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int i = mapper.deteleOne();
        System.out.println("i = " + i);
        sqlsession.close();
    }

    /**
     * 查询
     */
    @Test
    public void select(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.selectOne();
        System.out.println("user = " + user);

        System.out.println("-------------");
        List<User> users = mapper.selectAll();
        System.out.println("users = " + users);
        sqlsession.close();
    }
}
