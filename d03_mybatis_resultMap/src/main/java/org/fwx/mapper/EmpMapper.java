package org.fwx.mapper;

import org.apache.ibatis.annotations.Param;
import org.fwx.pojo.Emp;

import java.util.List;

/**
 * @ClassName EmpMapper
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 15:32
 * @Version 1.0
 */
public interface EmpMapper {
    /**
     * 根据 id 查询员工。
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") int empId);

    /**
     * 查询员工和部门信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptById(@Param("empId") int empId);

    /**
     * 分步查询：员工和部门信息，先获取员工信息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByIdSteps(@Param("empId") int empId);

    /**
     * 分步查询：根据部门 id 查询员工信息
     * @param deptId
     * @return
     */
    List<Emp> getEmpsByDetpId(@Param("deptId") int deptId);
}
