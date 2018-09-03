package com.lg.warehouse.service;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lin
 * @ClassName AdminService
 * @date 2018/9/3 16:09
 * @description
 **/


public interface EmployeeService {

    ResponseDTO<Employee> login(Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
