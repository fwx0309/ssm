package org.fwx.mapper;

import org.apache.ibatis.session.SqlSession;
import org.fwx.pojo.Emp;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName EmpMapper04Test
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 21:37
 * @Version 1.0
 */
public class EmpMapper04Test {
    /**
     * 多条件查询用户信息
     */
    @Test
    public void getEmpByConditionTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper04 mapper = sqlsession.getMapper(EmpMapper04.class);
//        Emp emp = new Emp(null, "张三", 18, "男");
        Emp emp = new Emp(null, "", 18,"" );
//        Emp emp = new Emp();
        List<Emp> emps = mapper.getEmpByCondition(emp);
        System.out.println("emps = " + emps);
    }

    /**
     * 多条件查询用户信息
     */
    @Test
    public void getEmpByChooseTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper04 mapper = sqlsession.getMapper(EmpMapper04.class);
        Emp emp = new Emp(null, "张三", 18, "男");
        List<Emp> emps = mapper.getEmpByChoose(emp);
        System.out.println("emps = " + emps);
    }

    /**
     * 批量添加用户
     */
    @Test
    public void insertEmpsTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper04 mapper = sqlsession.getMapper(EmpMapper04.class);
        Emp emp1 = new Emp(null, "小明1", 18, "男");
        Emp emp2 = new Emp(null, "小明2", 18, "男");
        Emp emp3 = new Emp(null, "小明3", 18, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertEmps(emps);

        // 查看返回数据中的自增主键
        System.out.println("emps = " + emps);
    }

    /**
     * 批量删除用户
     */
    @Test
    public void deleteEmpsTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper04 mapper = sqlsession.getMapper(EmpMapper04.class);
//        int[] ids = {};
        int[] ids = {1,2};
        mapper.deleteEmps(ids);
    }
}
