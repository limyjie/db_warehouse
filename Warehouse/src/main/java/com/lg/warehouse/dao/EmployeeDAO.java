package com.lg.warehouse.dao;


import com.lg.warehouse.entity.Employee;

/**
 * @author lin
 * @ClassName AdminDAO
 * @Description
 * @DATE 2018/9/3 17:04
 **/


public interface EmployeeDAO {
    Employee queryEmployeeByAccount(String account);
}
