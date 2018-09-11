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
import java.io.IOException;
import java.util.List;

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

        Employee getEmployee = employeeDao.queryEmployeeByAccount(employee.getAccount());

        String getPassword = getEmployee.getPassword();

        if(!getPassword.equals(employee.getPassword())){
            return new ResponseDTO<>(101,"账号与密码不匹配",null);
        }

        System.out.println(getEmployee.toString());




        HttpSession httpSession = httpServletRequest.getSession();

        httpSession.setAttribute("session_employee_name",employee);


        if(getEmployee.getAuthorities().equals("admin")){
            return new ResponseDTO<>(1,"success",null);
        }


        return new ResponseDTO<>(0,"success",null);

    }

    @Override
    public ResponseDTO<Employee> register(Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        System.out.println("insert"+employee.toString());

        Employee getEmployee = employeeDao.queryEmployeeByAccount(employee.getAccount());

        if(getEmployee!=null){
            return new ResponseDTO<>(30,"用户账号已存在",null);
        }

        employeeDao.addEmployeeByEntity(employee);

        return new ResponseDTO<>(0,"成功注册用户",null);
    }

    @Override
    public ResponseDTO<Employee> delete(String account, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {


        Employee getEmployee = employeeDao.queryEmployeeByAccount(account);

        if(getEmployee==null){
            return new ResponseDTO<>(30,"用户账号不存在",null);
        }

        employeeDao.deleteEmployeeByID(account);

        return new ResponseDTO<>(0,"成功删除用户",null);
    }

    @Override
    public ResponseDTO<List<Employee>> allEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

        List<Employee> employeeList;

        employeeList = employeeDao.queryAllEmployee();



        return new ResponseDTO<>(0,"查询所有职员成功",employeeList);
    }
}
