package com.lg.warehouse.service;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lin
 * @ClassName AdminService
 * @date 2018/9/3 16:09
 * @description
 **/


public interface EmployeeService {

    ResponseDTO<Employee> login(Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    ResponseDTO<Employee> register (Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    ResponseDTO<Employee> delete (String  account, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    ResponseDTO<List<Employee>> allEmployee (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
