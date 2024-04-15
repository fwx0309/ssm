package org.fwx.controller;

import org.fwx.dao.EmployeeDao;
import org.fwx.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ClassName EmployeeController
 * @Description
 *  查询所有的员工信息-->/employee-->get
 *  跳转到添加页面-->/to/add-->get
 *  新增员工信息-->/employee-->post
 *  跳转到修改页面-->/employee/1-->get
 *  修改员工信息-->/employee-->put
 *  删除员工信息-->/employee/1-->delete
 * @Author Fwx
 * @Date 2024/4/14 11:14
 * @Version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/to/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
