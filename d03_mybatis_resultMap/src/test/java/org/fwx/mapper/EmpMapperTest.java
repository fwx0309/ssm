package org.fwx.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fwx.pojo.Emp;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName EmpMapperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 15:39
 * @Version 1.0
 */
public class EmpMapperTest {

    /**
     * 根据 id 查询员工。
     */
    @Test
    public void getEmpById() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(EmpMapperTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = build.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println("emp = " + emp);
    }

    /**
     * 查询员工和部门信息
     * 1、级联方式
     * 2、association
     * 3、分步查询
     */
    @Test
    public void getEmpAndDeptByIdTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);
        /**
         * 1、级联查询
         * 2、association 查询
         */
        /*Emp emp = mapper.getEmpAndDeptById(1);
        System.out.println("emp = " + emp);*/

        /**
         * 3、分步查询。
         *  可以设置懒加载，在 mybatis-config.xml 中设置<setting name="lazyLoadingEnabled" value="true"/>
         *  在 ***Mappper.xml中设置 fetchType="eager(立即加载)
         */
        Emp emp1 = mapper.getEmpAndDeptByIdSteps(2);
        // System.out.println("emp1 = " + emp1);
        // 如果不查询关联表中的数据时，及不会去执行 sql 查询。
        System.out.println("emp1.getEmpName() = " + emp1.getEmpName());
    }
}
