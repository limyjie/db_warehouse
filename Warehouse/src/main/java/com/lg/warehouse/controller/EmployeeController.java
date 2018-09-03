package com.lg.warehouse.controller;

import com.alibaba.fastjson.JSON;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        System.out.println(employee.toString());
        return employeeService.login(employee, httpServletRequest, httpServletResponse);
    }
}
