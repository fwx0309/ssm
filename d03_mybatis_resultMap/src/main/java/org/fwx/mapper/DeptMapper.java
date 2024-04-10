package org.fwx.mapper;

import org.apache.ibatis.annotations.Param;
import org.fwx.pojo.Dept;

/**
 * @ClassName DeptMapper
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/10 19:55
 * @Version 1.0
 */
public interface DeptMapper {
    /**
     * 分步查询员工和部门信息，根据部门 id 获取部门信息
     * @param deptId
     * @return
     */
    Dept getDeptById(@Param("deptId") int deptId);

    /**
     * 查询部门信息及部门下的员工
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") int deptId);

    /**
     * 分步查询部门信息及部门下的员工
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptIdSteps(@Param("deptId") int deptId);
}
