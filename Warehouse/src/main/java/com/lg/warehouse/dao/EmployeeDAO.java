package com.lg.warehouse.dao;


import com.lg.warehouse.entity.Employee;

import java.util.List;

/**
 * @author lin
 * @ClassName AdminDAO
 * @Description
 * @DATE 2018/9/3 17:04
 **/


public interface EmployeeDAO {
    Employee queryEmployeeByAccount(String account);

    int addEmployeeByEntity(Employee employee);


    String queryIdentityNum(String idenNum);

    int deleteEmployeeByID(String account);

     List<Employee> queryAllEmployee();
}
