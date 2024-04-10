package org.fwx.mapper;

import org.apache.ibatis.annotations.Param;
import org.fwx.pojo.Emp;

import java.util.List;

/**
 * @ClassName EmpMapper
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 21:29
 * @Version 1.0
 */
public interface EmpMapper04 {

    /**
     * 多条件查询用户信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * choose件查询用户信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加用户
     * @param emps
     */
    void insertEmps(@Param("emps") List<Emp> emps);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteEmps(@Param("ids") int[] ids);
}
