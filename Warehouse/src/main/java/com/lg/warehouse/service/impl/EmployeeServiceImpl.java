package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.EmployeeDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lin
 * @ClassName AdminServiceImpl
 * @date 2018/9/3 16:50
 * @description
 **/

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public ResponseDTO<Employee> login(Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        String getPassword = employeeDao.queryEmployeeByAccount(employee.getAccount()).getPassword();

        if(!getPassword.equals(employee.getPassword())){
            return new ResponseDTO<>(101,"账号与密码不匹配",null);
        }

        System.out.println(employee.toString());

        HttpSession httpSession = httpServletRequest.getSession();

        httpSession.setAttribute("session_employee_name",employee);
        return new ResponseDTO<>(0,"success",null);

    }
}
