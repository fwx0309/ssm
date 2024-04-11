package org.fwx.mapper;

import org.apache.ibatis.session.SqlSession;
import org.fwx.pojo.Emp;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

/**
 * @ClassName EmpMapperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 11:00
 * @Version 1.0
 */
public class EmpMapperTest {
    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlsession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查询数据
        /*Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);*/
        //查询所有数据
        /*List<Emp> list = mapper.selectByExample(null);
        list.forEach(System.out::println);*/
        //根据条件查询数据
        /*EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("男");
        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);*/
        Emp emp = new Emp(1, "小黑", null, "女");
        //测试普通修改功能
        //mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }
}
