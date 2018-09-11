package com.lg.warehouse.controller;

import com.alibaba.fastjson.JSON;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lin
 * @ClassName EmployeeController
 * @date 2018/9/3 16:46
 * @description
 **/

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/login")
    public ResponseDTO login(@RequestBody String params, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Employee employee = JSON.parseObject(params,Employee.class);

        String authority = employee.getAuthorities();

        System.out.println(authority);
        return employeeService.login(employee, httpServletRequest, httpServletResponse);
    }


    @PostMapping(value = "register")
    public ResponseDTO<Employee> register(@RequestBody String params, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        System.out.println("params"+params);

        //分离employee 和 idenNum
        Employee employee = JSON.parseObject(params,Employee.class);

        System.out.println(employee.toString());

        return employeeService.register(employee,httpServletRequest,httpServletResponse);
    }

    @PostMapping(value = "deleteEmployee")
    public ResponseDTO<Employee> deleteEmployee(@RequestBody String params,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){



        return employeeService.delete(params,httpServletRequest,httpServletResponse);
    }

    @GetMapping(value = "allEmployee")
    public ResponseDTO<List<Employee>> queryAllEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        return employeeService.allEmployee(httpServletRequest, httpServletResponse);
    }

}
