package org.fwx.mapper.org.fwx.mapper;

import org.apache.ibatis.session.SqlSession;
import org.fwx.mapper.DeptMapper;
import org.fwx.pojo.Dept;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

/**
 * @ClassName DeptMapperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 20:53
 * @Version 1.0
 */
public class DeptMapperTest {
    /**
     * 一对多：查询部门信息及部门下的员工
     */
    @Test
    public void getDeptAndEmpByDeptId(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        DeptMapper mapper = sqlsession.getMapper(DeptMapper.class);
        // collection 查询
        /*Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println("dept = " + dept);*/

        // 分步查询
        Dept dept = mapper.getDeptAndEmpByDeptIdSteps(1);
        System.out.println("dept = " + dept);
    }
}
