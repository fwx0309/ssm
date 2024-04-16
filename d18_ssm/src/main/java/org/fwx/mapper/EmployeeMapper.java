package org.fwx.mapper;

import org.fwx.pojo.Employee;

import java.util.List;

/**
 * Description:
 */
public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();
}
